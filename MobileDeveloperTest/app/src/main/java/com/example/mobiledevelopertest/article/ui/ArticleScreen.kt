package com.example.mobiledevelopertest.ui.article

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mobiledevelopertest.article.data.network.response.Hit
import com.example.mobiledevelopertest.article.ui.ArticleViewModel
import com.example.mobiledevelopertest.article.ui.article.ArticleListItem
import com.example.mobiledevelopertest.core.entity.ArticleEntity
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleScreen(
    navController: NavHostController,
    articleViewModel: ArticleViewModel = viewModel()
) {
    val articles: List<ArticleEntity> by articleViewModel.articles.observeAsState(emptyList())
    val isLoading: Boolean by articleViewModel.isLoading.observeAsState(initial = false)
    val isRefreshing: Boolean by articleViewModel.isRefreshing.observeAsState(initial = false)
    val scope = rememberCoroutineScope()
    val error: String? by articleViewModel.error.observeAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        PullToRefreshBox(
            isRefreshing = isRefreshing,
            onRefresh = {
                scope.launch {
                    articleViewModel.fetchArticles(isRefresh = true)
                }
            },
            modifier = Modifier.fillMaxSize()
        ) {
            if (articles.isEmpty() && !isLoading) {
                Text(
                    text = error ?: "No articles found",
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(articles) { article ->
                        ArticleListItem(
                            article = article,
                            articleViewModel,
                            onArticleClick = { navController.navigate("articleDetail/${article.objectID}") }
                        )
                    }
                }
            }
        }

        if (isLoading && !isRefreshing) {
            CircularProgressIndicator()
        }
    }
}
