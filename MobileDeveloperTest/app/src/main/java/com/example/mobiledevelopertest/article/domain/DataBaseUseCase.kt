package com.example.mobiledevelopertest.article.domain

import com.example.mobiledevelopertest.article.data.DataBaseRepository
import com.example.mobiledevelopertest.core.entity.ArticleEntity
import javax.inject.Inject

class FetchDataUseCase @Inject constructor(
    private val repository: DataBaseRepository
) {
    suspend  fun getArticles(): List<ArticleEntity> {
        return try {
            repository.getArticles()
        } catch (e: Exception) {
            throw e
        }
    }

    suspend  fun saveArticles(articles: List<ArticleEntity>){
        return try {
            repository.saveArticles(articles)
        } catch (e: Exception) {
            throw e
        }
    }

    suspend  fun deleteArticle(articleId: ArticleEntity){
        return try {
            repository.deleteArticle(articleId)
        } catch (e: Exception) {
            throw e
        }
    }

}
