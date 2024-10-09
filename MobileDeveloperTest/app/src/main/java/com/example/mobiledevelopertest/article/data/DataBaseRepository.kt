package com.example.mobiledevelopertest.article.data

import com.example.mobiledevelopertest.core.dataBase.ArticleDao
import com.example.mobiledevelopertest.core.entity.ArticleEntity
import javax.inject.Inject

class DataBaseRepository @Inject constructor (private val articleDao: ArticleDao) {
    suspend fun saveArticles(articles: List<ArticleEntity>) {
        articleDao.insertArticles(articles)
    }

    suspend fun getArticles(): List<ArticleEntity> {
        return articleDao.getAllArticles()
    }

    suspend fun deleteArticle(articleId: ArticleEntity) {
        articleDao.delete(articleId)
    }
}

