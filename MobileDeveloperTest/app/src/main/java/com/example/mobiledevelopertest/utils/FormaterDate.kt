package com.example.mobiledevelopertest.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun formatArticleDate(dateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")
    val articleDate = inputFormat.parse(dateString) ?: return "Invalid date"
    val now = Date()
    val diffInMillis = now.time - articleDate.time
    val hoursDifference = diffInMillis / (1000 * 60 * 60)

    return when {
        hoursDifference < 24 -> {
            val timeFormat = SimpleDateFormat("H'h'", Locale.getDefault())
            timeFormat.format(articleDate)
        }
        hoursDifference < 48 -> "Yesterday"
        else -> {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            dateFormat.format(articleDate)
        }
    }
}