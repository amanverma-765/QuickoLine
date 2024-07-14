package org.quickoline.dashboard.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.quickoline.dashboard.presentation.components.Category
import org.quickoline.dashboard.presentation.components.PostListItemsCard
import org.quickoline.dashboard.presentation.components.SecondaryTopBarWithSearchBar
import org.quickoline.dashboard.presentation.viewmodel.post.PostUiEvents
import org.quickoline.dashboard.presentation.viewmodel.post.PostUiStates
import org.quickoline.domain.model.post.PostData
import org.quickoline.ui.components.GotErrorScreen
import org.quickoline.ui.shimmer.PostListCardShimmer
import org.quickoline.ui.theme.smallPadding
import org.quickoline.utils.ApiResponse
import org.quickoline.utils.plus

@Composable
internal fun PostListScreen(
    modifier: Modifier = Modifier,
    category: Category,
    uiState: PostUiStates,
    uiEvent: (PostUiEvents) -> Unit,
    navigateToPostDetail: (PostData) -> Unit,
    navigateBack: () -> Unit
) {

    val lazyState = rememberLazyListState()

    LaunchedEffect(key1 = Unit) {
        uiEvent(PostUiEvents.FetchPostData(category))
    }

    Scaffold(
        topBar = {
            SecondaryTopBarWithSearchBar(
                title = stringResource(id = category.title),
                lazyState = lazyState,
                navigateBack = { navigateBack() }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            state = lazyState,
            verticalArrangement = Arrangement.spacedBy(smallPadding),
            contentPadding = innerPadding.plus(PaddingValues(horizontal = smallPadding)),
            modifier = modifier.fillMaxSize()
        ) {

            when (val response = uiState.postResponse) {
                is ApiResponse.Error -> {
                    item {
                        Column(modifier = Modifier.fillParentMaxSize()) {
                            GotErrorScreen()
                        }
                    }
                }

                is ApiResponse.Loading -> {
                    items(15) { PostListCardShimmer() }
                }

                is ApiResponse.Success -> {
                    items(response.data) { data ->
                        PostListItemsCard(
                            postData = data,
                            category = category,
                            navigateToPostDetail = { postData ->
                                navigateToPostDetail(postData)
                            }
                        )
                    }
                }
            }
        }
    }
}