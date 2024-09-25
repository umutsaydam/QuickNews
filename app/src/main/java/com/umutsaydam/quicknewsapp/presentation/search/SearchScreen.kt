package com.umutsaydam.quicknewsapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.umutsaydam.quicknewsapp.domain.model.Article
import com.umutsaydam.quicknewsapp.presentation.Dimens.MediumPadding1
import com.umutsaydam.quicknewsapp.presentation.common.ArticlesList
import com.umutsaydam.quicknewsapp.presentation.common.SearchBar
import com.umutsaydam.quicknewsapp.presentation.nvgraph.Route
import com.umutsaydam.quicknewsapp.presentation.search.SearchEvent.UpdateSearchQuery

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigateToDetails: (Article) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(
                top = MediumPadding1,
                start = MediumPadding1,
                end = MediumPadding1
            )
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        SearchBar(text = state.searchQuery, readOnly = false, onValueChange = {
            event(
                UpdateSearchQuery(it)
            )
        },
            onSearch = { event(SearchEvent.SearchNews) })
        Spacer(modifier = Modifier.height(MediumPadding1))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(articles = articles, onClick = { navigateToDetails(it) })
        }
    }
}