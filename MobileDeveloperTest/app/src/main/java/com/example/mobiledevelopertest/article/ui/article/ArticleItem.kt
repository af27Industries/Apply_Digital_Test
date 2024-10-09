package com.example.mobiledevelopertest.article.ui.article

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mobiledevelopertest.article.data.network.response.Hit
import com.example.mobiledevelopertest.core.entity.ArticleEntity
import com.example.mobiledevelopertest.utils.formatArticleDate

@Composable
fun ArticleItem(article: ArticleEntity, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(14.dp)
            .clickable(onClick = onClick)
    ) {
        Column {
            Text(text = article.storyTitle ?: "No Story Title", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Text(text = article.author ?: "No Author", color = Color.Gray)
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "- ${formatArticleDate(article.createdAt ?: "")}",
                    color = Color.Gray
                )
            }
        }
    }
}
