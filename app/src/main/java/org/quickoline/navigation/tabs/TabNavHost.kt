package org.quickoline.navigation.tabs

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import org.quickoline.components.AddTabItem
import org.quickoline.features.tabs.activity.navigation.activityGraph
import org.quickoline.features.tabs.home.navigation.homeGraph

internal inline fun <reified T : Any> NavGraphBuilder.tabGraph(
    tabNavigator: NavHostController
) {

    composable<T> {

        val backStackEntry = tabNavigator.currentBackStackEntryAsState().value
        val currentDestination = backStackEntry?.destination
        val context = LocalContext.current

        Scaffold(
            contentWindowInsets = ScaffoldDefaults.contentWindowInsets.exclude(WindowInsets.statusBars),
            bottomBar = {
                NavigationBar(
                    contentColor = Color.Transparent,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    tabItems(context).forEach { tab ->
                        AddTabItem(
                            tab = tab,
                            onTabClicked = {
                                tabNavigator.navigate(tab.destination) {
                                    launchSingleTop = true
                                    restoreState = true
                                    popUpTo(tabNavigator.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                }
                            },
                            tabSelected = currentDestination?.hierarchy?.any {
                                it.hasRoute(tab.destination::class)
                            } == true
                        )
                    }
                }
            }
        ) { padding ->

            NavHost(
                navController = tabNavigator,
                startDestination = TabDestinations.HomeTab,

                enterTransition = { scaleIn(initialScale = 0.8f) + fadeIn() },
                popEnterTransition = { scaleIn(initialScale = 0.8f) + fadeIn() },
                popExitTransition = { fadeOut() },
                exitTransition = { fadeOut() },

                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {

                homeGraph<TabDestinations.HomeTab>()

                activityGraph<TabDestinations.ActivityTab>()
            }
        }
    }
}