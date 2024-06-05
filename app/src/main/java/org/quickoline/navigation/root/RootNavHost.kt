package org.quickoline.navigation.root

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.quickoline.activity.navigation.activityGraph
import org.quickoline.home.navigation.HomeGraph
import org.quickoline.home.navigation.homeGraph
import org.quickoline.onboarding.navigation.OnBoardingGraph
import org.quickoline.onboarding.navigation.onBoardingGraph
import org.quickoline.utils.canNavigate
import org.quickoline.webview.WebViewGraph
import org.quickoline.webview.webViewGraph

@Composable
fun RootNavHost(
    modifier: Modifier = Modifier,
    startDestination: Any
) {

    val rootNavigator = rememberNavController()

    NavHost(
        navController = rootNavigator,
        startDestination = startDestination,

        enterTransition = { slideInHorizontally { it } },
        exitTransition = { slideOutHorizontally { -it } },
        popEnterTransition = { slideInHorizontally { -it } },
        popExitTransition = { slideOutHorizontally { it } },

        modifier = modifier.fillMaxSize()
    ) {

        onBoardingGraph(
            navigateToDashboard = {
                if (rootNavigator.canNavigate()) {
                    rootNavigator.navigate(HomeGraph) {
                        popUpTo(OnBoardingGraph) { inclusive = true }
                    }
                }
            },
            navigateToPolicy = { url ->
                if (rootNavigator.canNavigate()) rootNavigator.navigate(WebViewGraph(url))
            }
        )

        webViewGraph(
            navigator = rootNavigator,
        )

        homeGraph(
            navigator = rootNavigator,
            navigateToOnBoarding = {
                if (rootNavigator.canNavigate()) {
                    rootNavigator.navigate(OnBoardingGraph) {
                        popUpTo(HomeGraph) { inclusive = true }
                    }
                }
            }
        )

        activityGraph(navigator = rootNavigator)

    }
}
