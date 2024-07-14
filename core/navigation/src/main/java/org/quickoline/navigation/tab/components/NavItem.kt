package org.quickoline.navigation.tab.components

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
//    val destination: TabDestinations,
    @StringRes
    val title: Int,
    val filledIcon: ImageVector,
    val outlinedIcon: ImageVector
)