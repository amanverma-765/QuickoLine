package org.quickoline.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kotlinx.serialization.Serializable
import org.quickoline.home.presentation.screens.HomeScreen
import org.quickoline.home.presentation.screens.PostListScreen

@Serializable
object HomeGraph

fun NavGraphBuilder.homeGraph(
    navigator: NavController,
) {

    navigation<HomeGraph>(startDestination = HomeDestinations.Home) {

        composable<HomeDestinations.Home> {
            HomeScreen(
                onNavigateToListScreen = { navigator.navigate(HomeDestinations.PostList) }
            )
        }

        composable<HomeDestinations.PostList> {
            PostListScreen()
        }
    }
}
