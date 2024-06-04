package org.quickoline.onboarding.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import org.quickoline.onboarding.presentation.screens.WelcomeScreen
import org.quickoline.onboarding.presentation.viewmodel.OnBoardingViewModel


@Serializable
object OnBoardingGraph

fun NavGraphBuilder.onBoardingGraph(
    navigateToDashboard: () -> Unit,
    navigateToPolicy: (String) -> Unit,
) {
    navigation<OnBoardingGraph>(startDestination = OnBoardingDestinations.Welcome) {

        composable<OnBoardingDestinations.Welcome> {

            val onBoardingVm = koinViewModel<OnBoardingViewModel>()
            val onBoardingState by onBoardingVm.onBoardingState.collectAsState()

            WelcomeScreen(
                uiEvents = onBoardingVm::onEvent,
                uiStates = onBoardingState,
                navigateToDashboard =navigateToDashboard,
                navigateToPolicy = { url -> navigateToPolicy(url) }
            )
        }
    }
}