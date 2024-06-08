package org.quickoline.onboarding.navigation

import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.quickoline.onboarding.presentation.screens.WelcomeScreen
import org.quickoline.onboarding.presentation.viewmodel.OnBoardingViewModel
import org.quickoline.utils.Constants
import org.quickoline.utils.Constants.USER_ENTRY
import org.quickoline.utils.canNavigate


@Serializable
object OnBoardingGraph

fun NavController.navigateToOnBoardingGraph(navOptions: NavOptions? = null) {
    if (canNavigate()) navigate(route = OnBoardingGraph, navOptions = navOptions)
}

fun NavGraphBuilder.onBoardingGraph(
    navigateToDashboard: () -> Unit,
    navigateToPolicy: (String) -> Unit,
) {
    navigation<OnBoardingGraph>(startDestination = OnBoardingDestinations.Welcome) {

        composable<OnBoardingDestinations.Welcome>(
            enterTransition = { slideInVertically { -it } },
            popExitTransition = { slideOutHorizontally { -it } },
        ) {

            val onBoardingVm = koinViewModel<OnBoardingViewModel>(
                parameters = { parametersOf(USER_ENTRY) }
            )
            val onBoardingState by onBoardingVm.onBoardingState.collectAsState()

            WelcomeScreen(
                uiEvent = onBoardingVm::onEvent,
                uiState = onBoardingState,
                navigateToDashboard = { navigateToDashboard() },
                navigateToPolicy = { url -> navigateToPolicy(url) }
            )
        }
    }
}