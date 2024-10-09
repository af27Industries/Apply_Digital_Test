package com.example.mobiledevelopertest.article.domain

import com.example.mobiledevelopertest.article.data.ArticleRepository
import com.example.mobiledevelopertest.article.data.network.response.ArticleResponse
import javax.inject.Inject

class FetchArticlesUseCase @Inject constructor(
    private val repository: ArticleRepository
) {
    suspend operator fun invoke(): ArticleResponse {
        return repository.getArticles()
    }
}
