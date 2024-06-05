package org.quickoline.home.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.quickoline.home.presentation.components.Category
import org.quickoline.home.presentation.screens.HomeScreen
import org.quickoline.home.presentation.screens.PostListScreen
import org.quickoline.home.presentation.viewmodel.home.HomeViewModel
import org.quickoline.home.presentation.viewmodel.userentry.UserEntryUiEvents
import org.quickoline.home.presentation.viewmodel.userentry.UserEntryViewModel
import org.quickoline.utils.canNavigate

@Serializable
object HomeGraph

fun NavGraphBuilder.homeGraph(
    navigator: NavController,
    navigateToOnBoarding: () -> Unit
) {
    navigation<HomeGraph>(startDestination = HomeDestinations.Home) {
        composable<HomeDestinations.Home> {

            val userEntryVm = koinViewModel<UserEntryViewModel>()
            val userEntryState by userEntryVm.userEntryState.collectAsState()

            LaunchedEffect(key1 = userEntryState) {
                userEntryVm.onEvent(UserEntryUiEvents.CheckIfOnBoardingIsCompleted)
                if (userEntryState.entryNotCompleted || userEntryState.policyNotAccepted) {
                    if (navigator.canNavigate()) navigateToOnBoarding()
                }
            }

            val homeVm = viewModel<HomeViewModel>()
            val homeUiState by homeVm.homeUiState.collectAsState()
            HomeScreen(
                uiStates = homeUiState,
                uiEvents = homeVm::onEvent,
                navigateToPostListScreen = { category ->
                    if (navigator.canNavigate()) {
                        navigator.navigate(HomeDestinations.PostList(category.name))
                    }
                }
            )
        }

        composable<HomeDestinations.PostList> { backStack ->

            val category = backStack.toRoute<HomeDestinations.PostList>().category

            PostListScreen(
                category = Category.valueOf(category),
                navigateBack = { if (navigator.canNavigate()) navigator.popBackStack() }
            )
        }
    }
}
