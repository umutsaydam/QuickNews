package com.umutsaydam.quicknewsapp.domain.usecases.news

import com.umutsaydam.quicknewsapp.data.local.NewsDao
import com.umutsaydam.quicknewsapp.domain.model.Article
import com.umutsaydam.quicknewsapp.domain.repository.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository,
) {
    suspend operator fun invoke(
        article: Article,
    ) {
        newsRepository.deleteArticle(article)
    }
}