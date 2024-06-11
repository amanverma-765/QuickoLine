package org.quickoline.navigation.tab.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContactPage
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.outlined.ContactPage
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Event
import org.quickoline.ui.R

val navigationTabs = listOf(

    NavItem(
//        destination = TabDestinations.HomeTab,
        title = R.string.home_tab,
        filledIcon = Icons.Filled.Dashboard,
        outlinedIcon = Icons.Outlined.Dashboard
    ),

    NavItem(
//        destination = TabDestinations.ActivityTab,
        title = R.string.docs_tab,
        filledIcon = Icons.Filled.ContactPage,
        outlinedIcon = Icons.Outlined.ContactPage
    ),

    NavItem(
//        destination = TabDestinations.ActivityTab,
        title = R.string.activities_tab,
        filledIcon = Icons.Filled.Event,
        outlinedIcon = Icons.Outlined.Event
    )

)