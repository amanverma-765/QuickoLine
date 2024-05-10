package org.quickoline.navigation.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.quickoline.features.tabs.home.navigation.homeGraph
import org.quickoline.features.onboarding.navigation.onBoardingGraph
import org.quickoline.navigation.tabs.tabGraph

@Composable
fun RootNavHost(modifier: Modifier = Modifier) {

    val rootNavigator = rememberNavController()
    val tabNavigator = rememberNavController()

    NavHost(
        navController = rootNavigator,
        startDestination = RootDestinations.TabGraph,
        modifier = modifier.fillMaxSize()
        ) {

        onBoardingGraph<RootDestinations.OnBoardingGraph>()

        tabGraph<RootDestinations.TabGraph>(tabNavigator = tabNavigator)

    }

}