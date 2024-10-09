package com.example.mobiledevelopertest.article.data.network
import com.example.mobiledevelopertest.article.data.network.response.ArticleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ArticleService @Inject constructor(
    private val apiService: ArticleApiClient
) {
    suspend fun getArticles(): ArticleResponse {
        return withContext(Dispatchers.IO) {
            val response = apiService.doArticle()
            response.body() ?: ArticleResponse()
        }
    }
}
