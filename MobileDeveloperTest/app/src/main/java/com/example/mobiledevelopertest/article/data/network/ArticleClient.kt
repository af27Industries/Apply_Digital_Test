package com.example.mobiledevelopertest.article.data.network

import com.example.mobiledevelopertest.article.data.network.response.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET

interface ArticleApiClient {
    @GET("v1/search_by_date?query=mobile")
    suspend fun doArticle(): Response<ArticleResponse>
}
