package org.quickoline.navigation.tab

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import org.quickoline.activity.navigation.navigateToActivityGraph
import org.quickoline.dashboard.navigation.navigateToDashBoardGraph
import org.quickoline.navigation.tab.components.BottomNavigationBar
import org.quickoline.navigation.tab.components.navigationTabs
import org.quickoline.utils.canNavigate

@Serializable
data object BottomNavGraph

fun NavController.navigateToBottomNavGraph(navOptions: NavOptions? = null) {
    if (canNavigate()) navigate(route = BottomNavGraph, navOptions = navOptions)
}

fun NavGraphBuilder.bottomNavGraph(
    navigator: NavController,
    navigateToDashboard: () -> Unit,
    navigateToActivity: () -> Unit,
    navigateToDocs: () -> Unit
) {
    composable<BottomNavGraph> {

        val pagerState = rememberPagerState(initialPage = 0, pageCount = { navigationTabs.size })
        val coroutineScope = rememberCoroutineScope()
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    selectedTabIndex = pagerState.currentPage,
                    onTabClicked = { tab ->
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(tab)
                        }
                    }
                )
            }
        ) { innerPadding ->
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.padding(innerPadding)
            ) { page ->
                when (page) {
                    0 -> navigator.navigateToDashBoardGraph()
                    1 -> navigator.navigateToActivityGraph()
                    2 -> navigator.navigateToActivityGraph()
                }
            }
        }
    }
}