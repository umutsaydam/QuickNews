package com.umutsaydam.quicknewsapp.presentation.bookmark

import com.umutsaydam.quicknewsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList(),
)
