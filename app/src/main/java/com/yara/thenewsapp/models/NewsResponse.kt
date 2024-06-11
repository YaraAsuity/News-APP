package com.yara.thenewsapp.models

import com.yara.thenewsapp.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)