package org.quickoline.dashboard.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.quickoline.dashboard.presentation.components.Category
import org.quickoline.dashboard.presentation.components.CategoryCardGrid
import org.quickoline.dashboard.presentation.components.PostListItemsCard
import org.quickoline.dashboard.presentation.components.TopBarWithSearchbar
import org.quickoline.dashboard.presentation.viewmodel.home.HomeUiEvents
import org.quickoline.dashboard.presentation.viewmodel.home.HomeUiStates
import org.quickoline.domain.model.post.PublicPostData
import org.quickoline.ui.components.GotErrorScreen
import org.quickoline.ui.shimmer.PostListCardShimmer
import org.quickoline.ui.theme.smallPadding
import org.quickoline.utils.ApiResponse
import org.quickoline.utils.plus

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    uiEvent: (HomeUiEvents) -> Unit,
    uiState: HomeUiStates,
    navigateToPostListScreen: (Category) -> Unit,
    navigateToPostDetail: (PublicPostData) -> Unit
) {

    val lazyState = rememberLazyListState()

    LaunchedEffect(key1 = Unit) {
        uiEvent(HomeUiEvents.FetchTrendingData)
    }

    Scaffold(
        modifier = modifier,
        topBar = { TopBarWithSearchbar(lazyState = lazyState) },
    ) { innerPadding ->
        LazyColumn(
            state = lazyState,
            verticalArrangement = Arrangement.spacedBy(smallPadding),
            contentPadding = innerPadding.plus(PaddingValues(horizontal = smallPadding)),
            modifier = Modifier.fillMaxSize()
        ) {

            item {
                CategoryCardGrid(
                    onClick = { category ->
                        navigateToPostListScreen(category)
                    }
                )
            }
            when (val response = uiState.trendingResponse) {
                is ApiResponse.Error -> {
                    item {
                        Column(modifier = Modifier.fillParentMaxHeight(.4f)) {
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
                            category = Category.MORE_SERVICES,
                            navigateToPostDetail = { postData ->
                                navigateToPostDetail(postData)
                            }
                        )
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}
