package org.quickoline.navigation.root

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.quickoline.activity.navigation.activityGraph
import org.quickoline.home.navigation.HomeGraph
import org.quickoline.home.navigation.homeGraph
import org.quickoline.navigation.NavViewModel
import org.quickoline.navigation.tabs.BottomNavigationBar
import org.quickoline.onboarding.navigation.OnBoardingGraph
import org.quickoline.onboarding.navigation.onBoardingGraph
import org.quickoline.webview.WebViewGraph
import org.quickoline.webview.webViewGraph

@Composable
fun RootNavHost(modifier: Modifier = Modifier) {

    val navVm = viewModel<NavViewModel>()

    val rootNavigator = rememberNavController().apply {
        addOnDestinationChangedListener { _, destination, _ ->
            navVm.destinationChanged(destination)
        }
    }

    val shouldShowNavBar = navVm.shouldShowBottomBar.collectAsState()
    val selectedTab = navVm.selectedTab.collectAsState()

    Scaffold(
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets.exclude(WindowInsets.statusBars),
        bottomBar = {
            if (shouldShowNavBar.value) {
                BottomNavigationBar(selectedTab = selectedTab.value) { rootNavigator.navigate(it) }
            }
        }
    ) { internalPadding ->
        NavHost(
            navController = rootNavigator,
            startDestination = OnBoardingGraph,
            modifier = modifier
                .fillMaxSize()
                .padding(internalPadding)
        ) {

            onBoardingGraph(
                onNavigateToDashboard = { rootNavigator.navigate(HomeGraph)},
                onNavigateToPolicy = { url -> rootNavigator.navigate(WebViewGraph(url)) }
            )

            webViewGraph(
                navigator = rootNavigator,
            )

            homeGraph(navigator = rootNavigator)

            activityGraph(navigator = rootNavigator)

        }
    }
}