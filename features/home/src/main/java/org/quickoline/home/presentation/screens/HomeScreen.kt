package org.quickoline.home.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.quickoline.home.presentation.components.CategoryCardGrid
import org.quickoline.home.presentation.components.ListItemsCard
import org.quickoline.home.presentation.components.TopBarWithSearchbar
import org.quickoline.home.presentation.viewmodel.home.HomeUiEvents
import org.quickoline.home.presentation.viewmodel.home.HomeUiStates
import org.quickoline.ui.theme.smallPadding

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    uiEvents: (HomeUiEvents) -> Unit,
    uiStates: HomeUiStates,
    navigateToPostListScreen: () -> Unit
) {

    val lazyState = rememberLazyListState()

    Scaffold(
        modifier = modifier,
        topBar = { TopBarWithSearchbar(lazyState = lazyState) },
    ) { padding ->

        LazyColumn(
            state = lazyState,
            verticalArrangement = Arrangement.spacedBy(smallPadding),
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {

            item {
                CategoryCardGrid(
                    onClick = { navigateToPostListScreen() }
                )
            }

            items(50) {
                ListItemsCard()
            }
        }
    }
}
