package org.quickoline.navigation.tabs

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import org.quickoline.R
import org.quickoline.components.NavItems


internal fun tabItems(context: Context): List<NavItems> {

    return listOf(
        NavItems(
            destination = TabDestinations.HomeTab,
            title = context.getString(R.string.home_tab),
            filledIcon = Icons.Filled.Home,
            outlinedIcon = Icons.Outlined.Home
        ),
        NavItems(
            destination = TabDestinations.ActivityTab,
            title = context.getString(R.string.activities_tab),
            filledIcon = Icons.Filled.ShoppingCart,
            outlinedIcon = Icons.Outlined.ShoppingCart
        )
    )
}
