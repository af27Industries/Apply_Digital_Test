package com.example.mobiledevelopertest.core.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mobiledevelopertest.article.data.network.response.Hit

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey val objectID: String,
    val storyTitle: String?,
    val commentText: String?,
    val storyUrl: String?,
    val imagesRes: Int?,
    val author: String?,
    val createdAt: String?,
    val deleted: Boolean = false
)

fun ArticleEntity.toHit(): Hit {
    return Hit(
        highlightResult = null,
        tags = emptyList(),
        author = this.author,
        commentText = this.commentText,
        createdAt = this.createdAt,
        createdAtI = null,
        objectID = this.objectID,
        parentId = null,
        storyId = null,
        storyTitle = this.storyTitle,
        storyUrl = this.storyUrl,
        updatedAt = null,
        imagesRes = this.imagesRes
    )
}

fun Hit.toArticleEntity(): ArticleEntity {
    return ArticleEntity(
        objectID = this.objectID ?: "",
        storyTitle = this.storyTitle,
        commentText = this.commentText,
        storyUrl = this.storyUrl,
        imagesRes = this.imagesRes ?: 0,
        author = this.author,
        createdAt = this.createdAt

    )
}