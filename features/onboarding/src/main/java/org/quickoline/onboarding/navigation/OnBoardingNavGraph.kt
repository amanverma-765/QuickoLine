package org.quickoline.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import org.quickoline.onboarding.presentation.screens.WelcomeScreen


@Serializable
object OnBoardingGraph

fun NavGraphBuilder.onBoardingGraph(
    navigator: NavController,
) {
    navigation<OnBoardingGraph>(startDestination = OnBoardingDestinations.Welcome) {

        composable<OnBoardingDestinations.Welcome> { WelcomeScreen() }
    }
}