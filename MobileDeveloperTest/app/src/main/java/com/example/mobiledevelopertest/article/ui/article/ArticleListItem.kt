package com.example.mobiledevelopertest.article.ui.article

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.mobiledevelopertest.article.data.network.response.Hit
import com.example.mobiledevelopertest.article.ui.ArticleViewModel
import com.example.mobiledevelopertest.core.entity.ArticleEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleListItem(
    article: ArticleEntity,
    viewModel: ArticleViewModel,
    onArticleDismissed: (ArticleEntity) -> Unit = {},
    onArticleClick: () -> Unit
) {
    var isDismissed by remember { mutableStateOf(false) }

    if (!isDismissed) {
        val dismissState = rememberSwipeToDismissBoxState(
            confirmValueChange = { dismissValue ->
                if (dismissValue == SwipeToDismissBoxValue.EndToStart) {
                    viewModel.deleteArticle(article)
                    isDismissed = true
                    onArticleDismissed(article)
                    true
                } else {
                    false
                }
            }
        )
        SwipeToDismissArticleItem(
            dismissState = dismissState,
            article = article,
            onClick = { onArticleClick() }
        )
    }
}
