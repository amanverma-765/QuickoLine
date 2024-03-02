package org.quickoline.ui.screens.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun QuickBottomBar() {

    val navItems = listOf(
        BottomBarData("Home", Icons.Outlined.Home, Icons.Filled.Home),
        BottomBarData("Cart", Icons.Outlined.ShoppingCart, Icons.Filled.ShoppingCart),
        BottomBarData("Offers", Icons.Outlined.Email, Icons.Filled.Email),
        BottomBarData("Account", Icons.Outlined.Person, Icons.Filled.Person)
    )

    val navState = rememberSaveable { mutableIntStateOf(0) }

    NavigationBar {

        navItems.forEachIndexed { index, items ->

            NavigationBarItem(
                selected = navState.intValue == index,
                onClick = { navState.intValue = index },
                icon = {
                    AnimatedVisibility(
                        visible = navState.intValue == index,
                        enter = fadeIn(animationSpec = tween(500)) + slideInVertically { it / 2 },
                        exit = fadeOut(animationSpec = tween(500))
                    ) {
                        Icon(imageVector = items.selectedIcon, contentDescription = items.title)
                    }

                    AnimatedVisibility(
                        visible = navState.intValue != index,
                        enter = fadeIn(animationSpec = tween(500)),
                        exit = fadeOut(animationSpec = tween(100)) + slideOutVertically { -it / 2 }
                    ) {

                        Icon(imageVector = items.unselectedIcon, contentDescription = items.title)
                    }
                },
                label = {
                    Text(
                        text = items.title,
                        modifier = Modifier.animateContentSize()
                    )
                },
            )

        }

    }
}

data class BottomBarData(

    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector

)