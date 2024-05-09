package org.quickoline.features.tabs.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import org.quickoline.features.tabs.home.presentation.screens.HomeScreen
internal inline fun <reified T: Any> NavGraphBuilder.homeGraph() {

    navigation<T>(startDestination = HomeDestinations.Home) {

        composable<HomeDestinations.Home> {
            HomeScreen()
        }
    }
}
