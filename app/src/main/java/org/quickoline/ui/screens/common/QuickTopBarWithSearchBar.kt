package org.quickoline.ui.screens.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import org.quickoline.ui.screens.utils.isScrollingUp

@Composable
fun QuickTopBarWithSearchBar(
    lazyState: LazyListState,
    isSearchBarActive: MutableState<Boolean>,
    query: MutableState<String>,
    drawerState: DrawerState
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colorScheme.background)
    ) {

        AnimatedVisibility(
            visible = !isSearchBarActive.value,
            exit = shrinkVertically { -it },
            enter = expandVertically { -it }
        ) {

            QuickTopAppBar(lazyState, drawerState)

        }

        AnimatedVisibility(visible = lazyState.isScrollingUp()) {
            QuickSearchBar(query, isSearchBarActive)
        }
    }
}