package org.quickoline.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import org.quickoline.navigation.tabs.TabDestinations

@Composable
fun RowScope.AddTabItem(
    tab: NavItems,
    onTabClicked: () -> Unit,
    tabSelected: Boolean
) {

    NavigationBarItem(
        modifier = Modifier,
        selected = tabSelected,
        alwaysShowLabel = true,
        onClick = { onTabClicked() },
        icon = {
            Icon(
                imageVector = if (tabSelected) tab.filledIcon else tab.outlinedIcon,
                contentDescription = tab.title,
            )
        },
        label = {
            Text(
                text = tab.title,
                fontWeight = if (tabSelected) FontWeight.Bold else FontWeight.Medium
            )
        }
    )
}



data class NavItems(
    val destination: TabDestinations,
    val title: String,
    val filledIcon: ImageVector,
    val outlinedIcon: ImageVector
)