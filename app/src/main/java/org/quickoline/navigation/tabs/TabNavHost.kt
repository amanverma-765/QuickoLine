package org.quickoline.navigation.tabs

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
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

        val navItems = listOf(
            TabDestinations.HomeTab,
            TabDestinations.ActivityTab
        )

        val backStackEntry = tabNavigator.currentBackStackEntryAsState().value
        val currentDestination = backStackEntry?.destination

        Scaffold(
            contentWindowInsets = ScaffoldDefaults.contentWindowInsets.exclude(WindowInsets.statusBars),
            bottomBar = {

                NavigationBar(modifier = Modifier.fillMaxWidth()) {
                    navItems.forEach { tab ->
                        AddTabItem(
                            tab = tab,
                            onTabClicked = { tabNavigator.navigate(tab) },
                            isTabSelected = currentDestination?.hierarchy?.any {
                                it.hasRoute(tab::class)
                            } == true
                        )
                    }
                }
            }
        ) { padding ->

            NavHost(
                navController = tabNavigator,
                startDestination = TabDestinations.HomeTab,
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