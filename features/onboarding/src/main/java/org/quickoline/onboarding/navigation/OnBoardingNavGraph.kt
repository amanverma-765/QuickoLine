package org.quickoline.onboarding.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import org.quickoline.onboarding.presentation.screens.WelcomeScreen


@Serializable
object OnBoardingGraph

fun NavGraphBuilder.onBoardingGraph(
    onNavigateToDashboard: () -> Unit,
    onNavigateToPolicy: (String) -> Unit
) {
    navigation<OnBoardingGraph>(startDestination = OnBoardingDestinations.Welcome) {

        composable<OnBoardingDestinations.Welcome>(
            exitTransition = { slideOutVertically(tween(500)) { -it } }
        ) {
            WelcomeScreen(
                onNavigateToDashboard = onNavigateToDashboard,
                onNavigateToPolicy = { url -> onNavigateToPolicy(url) }
            )
        }
    }
}