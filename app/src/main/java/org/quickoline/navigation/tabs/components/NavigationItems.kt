package org.quickoline.navigation.tabs.components

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Event
import androidx.compose.ui.graphics.vector.ImageVector
import org.quickoline.navigation.tabs.TabDestinations
import org.quickoline.ui.R

val navigationTabs = listOf(

    NavItem(
        destination = TabDestinations.HomeTab,
        title = R.string.home_tab,
        filledIcon = Icons.Filled.Dashboard,
        outlinedIcon = Icons.Outlined.Dashboard
    ),

    NavItem(
        destination = TabDestinations.ActivityTab,
        title = R.string.activities_tab,
        filledIcon = Icons.Filled.Event,
        outlinedIcon = Icons.Outlined.Event
    )

)

data class NavItem(
    val destination: TabDestinations,
    @StringRes
    val title: Int,
    val filledIcon: ImageVector,
    val outlinedIcon: ImageVector
)