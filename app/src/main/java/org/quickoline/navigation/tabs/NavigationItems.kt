package org.quickoline.navigation.tabs

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Event
import androidx.compose.ui.graphics.vector.ImageVector
import org.quickoline.activity.navigation.ActivityGraph
import org.quickoline.home.navigation.HomeGraph
import org.quickoline.ui.R

val navigationTabs = listOf(

    NavItem(
        destination = HomeGraph,
        title = R.string.home_tab,
        filledIcon = Icons.Filled.Dashboard,
        outlinedIcon = Icons.Outlined.Dashboard,
        selected = false
    ),

    NavItem(
        destination = ActivityGraph,
        title = R.string.activities_tab,
        filledIcon = Icons.Filled.Event,
        outlinedIcon = Icons.Outlined.Event,
        selected = false
    )

)

data class NavItem(
    val destination: Any,
    @StringRes
    val title: Int,
    val filledIcon: ImageVector,
    val outlinedIcon: ImageVector,
    val selected: Boolean
)