package com.yara.thenewsapp.models

import com.yara.thenewsapp.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)
