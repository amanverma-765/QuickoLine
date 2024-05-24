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
import org.quickoline.ui.theme.standardPadding

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToListScreen: () -> Unit
) {

    val lazyState = rememberLazyListState()

    Scaffold(
        modifier = modifier,
        topBar = { TopBarWithSearchbar(lazyState = lazyState) },
    ) { padding ->

        LazyColumn(
            state = lazyState,
            verticalArrangement = Arrangement.spacedBy(standardPadding),
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {

            item {
                CategoryCardGrid()
            }

            items(50) {
               ListItemsCard()
            }
        }
    }
}