package com.example.mobiledevelopertest.article.data.network.response

import com.google.gson.annotations.SerializedName

data class Exhaustive(
    @SerializedName("nbHits") var nbHits: Boolean?,
    @SerializedName("typo") var typo: Boolean?
)

data class HighlightResult(
    @SerializedName("author") var author: Highlight?,
    @SerializedName("comment_text") var commentText: Highlight?,
    @SerializedName("story_title") var storyTitle: Highlight?,
    @SerializedName("story_url") var storyUrl: Highlight?
)

data class Highlight(
    @SerializedName("fullyHighlighted") var fullyHighlighted: Boolean?,
    @SerializedName("matchLevel") var matchLevel: String?,
    @SerializedName("matchedWords") var matchedWords: List<String>?,
    @SerializedName("value") var value: String?
)

data class Hit(
    @SerializedName("_highlightResult") var highlightResult: HighlightResult?,
    @SerializedName("_tags") var tags: List<String>?,
    @SerializedName("author") var author: String?,
    @SerializedName("comment_text") var commentText: String?,
    @SerializedName("created_at") var createdAt: String?,
    @SerializedName("created_at_i") var createdAtI: Int?,
    @SerializedName("objectID") var objectID: String?,
    @SerializedName("parent_id") var parentId: String?,
    @SerializedName("story_id") var storyId: Int?,
    @SerializedName("story_title") var storyTitle: String?,
    @SerializedName("story_url") var storyUrl: String?,
    @SerializedName("updated_at") var updatedAt: String?,
    @SerializedName("imagesRes") var imagesRes: Int?
)

data class ArticleResponse(
    @SerializedName("exhaustive") var exhaustive: Exhaustive? = null,
    @SerializedName("exhaustiveNbHits") var exhaustiveNbHits: Boolean? = null,
    @SerializedName("exhaustiveTypo") var exhaustiveTypo: Boolean? = null,
    @SerializedName("hits") var hits: List<Hit>? = null,
    @SerializedName("hitsPerPage") var hitsPerPage: Int? = null,
    @SerializedName("nbHits") var nbHits: Int? = null,
    @SerializedName("nbPages") var nbPages: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("params") var params: String? = null,
    @SerializedName("processingTimeMS") var processingTimeMS: Int? = null,
    @SerializedName("processingTimingsMS") var processingTimingsMS: ProcessingTimings? = null,
    @SerializedName("query") var query: String? = null,
    @SerializedName("serverTimeMS") var serverTimeMS: Int? = null
)


data class ProcessingTimings(
    @SerializedName("afterFetch") var afterFetch: AfterFetch?,
    @SerializedName("fetch") var fetch: Fetch?,
    @SerializedName("total") var total: Int?
)

data class AfterFetch(
    @SerializedName("format") var format: Format?,
    @SerializedName("total") var total: Int?
)

data class Format(
    @SerializedName("highlighting") var highlighting: Int?,
    @SerializedName("total") var total: Int?
)

data class Fetch(
    @SerializedName("query") var query: Int?,
    @SerializedName("total") var total: Int?
)
