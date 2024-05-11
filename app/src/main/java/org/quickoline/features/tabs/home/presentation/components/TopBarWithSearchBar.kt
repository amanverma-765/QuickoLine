package org.quickoline.features.tabs.home.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.quickoline.components.QuickSearchBar
import org.quickoline.components.QuickTopAppBar
import org.quickoline.theme.standardPadding
import org.quickoline.utils.isScrollingUp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithSearchbar(modifier: Modifier = Modifier, lazyState: LazyListState) {

    var isSearchActive by remember { mutableStateOf(false) }
    
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(TopAppBarDefaults.topAppBarColors().containerColor)
    ) {

        AnimatedVisibility(visible = !isSearchActive) {
            QuickTopAppBar(
                containerColor = if (!lazyState.isScrollingUp()) {
                    TopAppBarDefaults.topAppBarColors().scrolledContainerColor
                } else {
                    TopAppBarDefaults.topAppBarColors().containerColor
                }
            )
        }

        AnimatedVisibility(visible = lazyState.isScrollingUp()) {
            QuickSearchBar(
                activeState = { state ->
                    isSearchActive = state
                }
            )
        }
        AnimatedVisibility(visible = lazyState.isScrollingUp()) {
            Spacer(modifier = Modifier.height(standardPadding))
        }
    }
}