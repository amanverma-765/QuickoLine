package org.quickoline.navigation.root

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.quickoline.activity.navigation.activityGraph
import org.quickoline.dashboard.navigation.DashboardGraph
import org.quickoline.dashboard.navigation.dashboardGraph
import org.quickoline.dashboard.navigation.navigateToDashBoardGraph
import org.quickoline.onboarding.navigation.OnBoardingGraph
import org.quickoline.onboarding.navigation.navigateToOnBoardingGraph
import org.quickoline.onboarding.navigation.onBoardingGraph
import org.quickoline.webview.navigateToWebViewGraph
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

//        bottomNavGraph(
//            navigator = rootNavigator,
//            navigateToDashboard = { rootNavigator.navigateToDashBoardGraph() },
//            navigateToActivity = { rootNavigator.navigateToActivityGraph() },
//            navigateToDocs = { rootNavigator.navigateToActivityGraph() }
//        )

        onBoardingGraph(
            navigateToDashboard = {
                rootNavigator.navigateToDashBoardGraph(
                    navOptions = navOptions {
                        popUpTo(OnBoardingGraph) { inclusive = true }
                    }
                )
            },
            navigateToPolicy = { url -> rootNavigator.navigateToWebViewGraph(url = url) }
        )

        webViewGraph(navigator = rootNavigator)

        dashboardGraph(
            navigator = rootNavigator,
            navigateToOnBoarding = {
                rootNavigator.navigateToOnBoardingGraph(
                    navOptions = navOptions {
                        popUpTo(DashboardGraph) { inclusive = true }
                    }
                )
            },
            navigateToSource = { url -> rootNavigator.navigateToWebViewGraph(url = url) },
            navigateToWebsite = { url -> rootNavigator.navigateToWebViewGraph(url = url) }
        )

        activityGraph(navigator = rootNavigator)

    }
}
