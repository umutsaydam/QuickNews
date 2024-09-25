package com.umutsaydam.quicknewsapp.presentation.details

import com.umutsaydam.quicknewsapp.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()
    object RemoveSideEffect : DetailsEvent()
}