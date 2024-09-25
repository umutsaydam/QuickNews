package com.umutsaydam.quicknewsapp.data.remote.dto

import com.umutsaydam.quicknewsapp.domain.model.Article

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>,
)
