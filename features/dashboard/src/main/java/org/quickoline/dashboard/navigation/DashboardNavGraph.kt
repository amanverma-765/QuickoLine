package org.quickoline.dashboard.navigation

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
import org.quickoline.dashboard.presentation.components.Category
import org.quickoline.dashboard.presentation.screens.HomeScreen
import org.quickoline.dashboard.presentation.screens.PostListScreen
import org.quickoline.dashboard.presentation.viewmodel.home.HomeViewModel
import org.quickoline.dashboard.presentation.viewmodel.userentry.UserEntryUiEvents
import org.quickoline.dashboard.presentation.viewmodel.userentry.UserEntryViewModel
import org.quickoline.utils.canNavigate

@Serializable
object DashboardGraph

fun NavGraphBuilder.dashboardGraph(
    navigator: NavController,
    navigateToOnBoarding: () -> Unit
) {
    navigation<DashboardGraph>(startDestination = DashboardDestinations.Home) {

        composable<DashboardDestinations.Home> {

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
                        navigator.navigate(DashboardDestinations.PostList(category.name))
                    }
                }
            )
        }

        composable<DashboardDestinations.PostList> { backStack ->

            val category = backStack.toRoute<DashboardDestinations.PostList>().category

            PostListScreen(
                category = Category.valueOf(category),
                navigateBack = { if (navigator.canNavigate()) navigator.popBackStack() }
            )
        }
    }
}
