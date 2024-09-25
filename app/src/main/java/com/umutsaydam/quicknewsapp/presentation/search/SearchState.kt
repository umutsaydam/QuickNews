package com.umutsaydam.quicknewsapp.presentation.search

import androidx.paging.PagingData
import com.umutsaydam.quicknewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)