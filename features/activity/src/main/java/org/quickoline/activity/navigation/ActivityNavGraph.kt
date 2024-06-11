package org.quickoline.activity.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kotlinx.serialization.Serializable
import org.quickoline.activity.presentation.screens.ActivityScreen
import org.quickoline.utils.canNavigate

@Serializable
object ActivityGraph

fun NavController.navigateToActivityGraph(navOptions: NavOptions? = null) {
    if (canNavigate()) navigate(route = ActivityGraph, navOptions = navOptions)
}


fun NavGraphBuilder.activityGraph(
    navigator: NavController
) {

    navigation<ActivityGraph>(startDestination = ActivityDestinations.Activity) {

        composable<ActivityDestinations.Activity> {
            ActivityScreen()
        }

    }

}
