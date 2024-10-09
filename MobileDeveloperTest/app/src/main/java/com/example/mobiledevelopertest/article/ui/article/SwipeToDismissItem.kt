package com.example.mobiledevelopertest.article.ui.article
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mobiledevelopertest.article.data.network.response.Hit
import com.example.mobiledevelopertest.core.entity.ArticleEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeToDismissArticleItem(
    dismissState: SwipeToDismissBoxState,
    article: ArticleEntity,
    onClick: () -> Unit
) {
    Column {
        SwipeToDismissBox(
            state = dismissState,
            backgroundContent = { SwipeToDismissBackground() },
            content = { SwipeToDismissContent(article, onClick) })
        HorizontalDivider(color = Color.Gray, thickness = 1.dp)
    }
}

@Composable
fun SwipeToDismissBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(14.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = "Delete",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SwipeToDismissContent(article: ArticleEntity, onClick: () -> Unit) {
    ArticleItem(article = article, onClick = onClick)
}

