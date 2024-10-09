package com.example.mobiledevelopertest.core.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mobiledevelopertest.core.entity.ArticleEntity

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<ArticleEntity>)

    @Query("SELECT * FROM articles")
    suspend fun getAllArticles(): List<ArticleEntity>

    @Delete
    suspend fun delete(article: ArticleEntity)

    @Query("DELETE FROM articles WHERE objectID = :articleId")
    suspend fun deleteById(articleId: String)
}