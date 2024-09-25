package com.umutsaydam.quicknewsapp.domain.usecases.news

import com.umutsaydam.quicknewsapp.data.local.NewsDao
import com.umutsaydam.quicknewsapp.domain.model.Article
import com.umutsaydam.quicknewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository,
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }
}