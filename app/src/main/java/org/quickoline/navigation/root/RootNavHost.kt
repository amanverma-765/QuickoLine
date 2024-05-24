package org.quickoline.navigation.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.quickoline.activity.navigation.activityGraph
import org.quickoline.home.navigation.homeGraph
import org.quickoline.onboarding.navigation.onBoardingGraph

@Composable
fun RootNavHost(modifier: Modifier = Modifier) {

    val rootNavigator = rememberNavController()

    NavHost(
        navController = rootNavigator,
        startDestination = org.quickoline.home.navigation.HomeGraph,
        modifier = modifier.fillMaxSize()
    ) {

        onBoardingGraph(navigator = rootNavigator)

        homeGraph(navigator = rootNavigator)

        activityGraph(navigator = rootNavigator)

    }
}