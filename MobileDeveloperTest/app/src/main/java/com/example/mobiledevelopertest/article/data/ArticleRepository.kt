package com.example.mobiledevelopertest.article.data

import com.example.mobiledevelopertest.article.data.network.ArticleService
import com.example.mobiledevelopertest.article.data.network.response.ArticleResponse
import javax.inject.Inject

class ArticleRepository @Inject constructor (
    private val articleService: ArticleService
) {
     suspend fun getArticles(): ArticleResponse {
        return articleService.getArticles()
    }
}
