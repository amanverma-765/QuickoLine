package org.quickoline.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import org.quickoline.navigation.tabs.TabDestinations

@Composable
fun RowScope.AddTabItem(
    tab: TabDestinations,
    onTabClicked: () -> Unit,
    isTabSelected: Boolean
) {

    NavigationBarItem(
        selected = isTabSelected,
        onClick = { onTabClicked() },
        icon = {
            Icon(
                imageVector = if (isTabSelected) tab.filledIcon else tab.outlinedIcon,
                contentDescription = tab.title,
                tint = if (isTabSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground)
        },
        label = {
            Text(
                text = tab.title,
                fontWeight = if (isTabSelected) FontWeight.Bold else FontWeight.Medium
            )
        }
    )

}