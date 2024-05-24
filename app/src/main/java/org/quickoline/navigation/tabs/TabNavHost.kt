package org.quickoline.navigation.tabs

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.quickoline.activity.navigation.activityGraph
import org.quickoline.home.navigation.homeGraph
import org.quickoline.navigation.tabs.components.BottomNavigationBar


inline fun <reified T : Any> NavGraphBuilder.tabGraph(
    rootNavigator: NavHostController
) {

    composable<T> {
        val tabNavigator = rememberNavController()

        Scaffold(
            contentWindowInsets = ScaffoldDefaults.contentWindowInsets.exclude(WindowInsets.statusBars),
            bottomBar = {
                BottomNavigationBar(
                    tabNavigator = tabNavigator,
                    onTabClicked = { tab ->
                        tabNavigator.navigate(tab)
                    }
                )
            }
        ) { innerPadding ->

            NavHost(
                navController = tabNavigator,
                startDestination = TabDestinations.HomeTab,

                enterTransition = { scaleIn(initialScale = 0.7f) + fadeIn() },
                popEnterTransition = { scaleIn(initialScale = 0.7f) + fadeIn() },
                popExitTransition = { fadeOut() },
                exitTransition = { fadeOut() },

                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {

                homeGraph(tabNavigator)

                activityGraph(rootNavigator)
            }
        }
    }
}