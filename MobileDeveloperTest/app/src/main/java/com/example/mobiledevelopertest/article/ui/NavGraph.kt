package com.example.mobiledevelopertest.article.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobiledevelopertest.article.ui.ArticleDetailScreen
import com.example.mobiledevelopertest.article.ui.ArticleViewModel
import com.example.mobiledevelopertest.ui.article.ArticleScreen

@Composable
fun NavGraph(navController: NavHostController, viewModel: ArticleViewModel, startDestination: String = "articleList") {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("articleList") {
            ArticleScreen(navController, viewModel)
        }

        composable("articleDetail/{articleId}") { backStackEntry ->
            val articleId = backStackEntry.arguments?.getString("articleId")
            val article = viewModel.getArticleById(articleId)
            if (article != null) {
                ArticleDetailScreen(article = article, navController = navController)
            }
        }
    }
}
