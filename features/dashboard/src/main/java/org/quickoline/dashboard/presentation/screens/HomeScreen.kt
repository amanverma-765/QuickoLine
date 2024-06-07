package org.quickoline.dashboard.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.quickoline.dashboard.presentation.components.Category
import org.quickoline.dashboard.presentation.components.CategoryCardGrid
import org.quickoline.dashboard.presentation.components.PostListItemsCard
import org.quickoline.dashboard.presentation.components.TopBarWithSearchbar
import org.quickoline.dashboard.presentation.viewmodel.home.HomeUiEvents
import org.quickoline.dashboard.presentation.viewmodel.home.HomeUiStates
import org.quickoline.ui.theme.smallPadding
import org.quickoline.utils.plus

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    uiEvents: (HomeUiEvents) -> Unit,
    uiStates: HomeUiStates,
    navigateToPostListScreen: (Category) -> Unit
) {

    val lazyState = rememberLazyListState()

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

            items(50) {
                PostListItemsCard()
            }

        }
    }
}
