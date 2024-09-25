package com.umutsaydam.quicknewsapp.domain.usecases.news

import androidx.paging.PagingData
import com.umutsaydam.quicknewsapp.domain.model.Article
import com.umutsaydam.quicknewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository,
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery = searchQuery, sources = sources)
    }
}