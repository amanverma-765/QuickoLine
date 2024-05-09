package org.quickoline.features.tabs.activity.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import org.quickoline.features.tabs.activity.presentation.screens.ActivityScreen

internal inline fun <reified T: Any> NavGraphBuilder.activityGraph() {

    navigation<T>(startDestination = ActivityDestinations.Activity) {

        composable<ActivityDestinations.Activity> {
            ActivityScreen()
        }

    }

}
