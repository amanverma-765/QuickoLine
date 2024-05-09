package org.quickoline.features.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import org.quickoline.features.onboarding.presentation.screens.WelcomeScreen

inline fun <reified T: Any>NavGraphBuilder.onBoardingGraph() {

    navigation<T>(startDestination = OnBoardingDestinations.Welcome) {

        composable<OnBoardingDestinations.Welcome> {
            WelcomeScreen()
        }

    }
}