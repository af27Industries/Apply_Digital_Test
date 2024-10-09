package com.example.mobiledevelopertest.article.ui
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiledevelopertest.article.domain.FetchArticlesUseCase
import com.example.mobiledevelopertest.article.domain.FetchDataUseCase
import com.example.mobiledevelopertest.core.entity.ArticleEntity
import com.example.mobiledevelopertest.core.entity.toArticleEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val fetchArticlesUseCase: FetchArticlesUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val dataBaseUseCase: FetchDataUseCase
) : ViewModel() {

    private val _articles = savedStateHandle.getLiveData<List<ArticleEntity>>("articles", emptyList())
    val articles: LiveData<List<ArticleEntity>> = _articles

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isRefreshing = MutableLiveData(false)
    val isRefreshing: LiveData<Boolean> get() = _isRefreshing

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    init {
        fetchLocalArticles()
        fetchArticles()
    }

    private fun fetchLocalArticles() {
        viewModelScope.launch {
            try {
                val localArticles = dataBaseUseCase.getArticles()
                if (localArticles.isNotEmpty()) {
                    _articles.value = localArticles
                }
            } catch (e: Exception) {
                _error.value = "Failed to fetch local articles"
            }
        }
    }

    fun fetchArticles(isRefresh: Boolean = false) {
        viewModelScope.launch {
            if (isRefresh) _isRefreshing.value = true else _isLoading.value = true

            try {
                val result = fetchArticlesUseCase()
                val articles = result.hits?.map { it.toArticleEntity() } ?: emptyList()

                if (articles.isNotEmpty()) {
                    _articles.value = articles
                    savedStateHandle["articles"] = articles
                    dataBaseUseCase.saveArticles(articles)
                } else {
                    fetchLocalArticles()
                }
            } catch (e: Exception) {
                _error.value = "Failed to fetch articles"
                fetchLocalArticles()
            } finally {
                _isLoading.value = false
                _isRefreshing.value = false
            }
        }
    }

    fun deleteArticle(articleId: ArticleEntity) {
        viewModelScope.launch {
            try {
                dataBaseUseCase.deleteArticle(articleId)
                val updatedArticles = _articles.value?.filter { it.objectID != articleId.objectID } ?: emptyList()
                _articles.value = updatedArticles
                savedStateHandle["articles"] = updatedArticles
                dataBaseUseCase.saveArticles(updatedArticles)
            } catch (e: Exception) {
                _error.value = "Failed to delete article"
            }
        }
    }

    fun getArticleById(articleId: String?): ArticleEntity? {
        return _articles.value?.find { it.objectID == articleId }
    }
}
