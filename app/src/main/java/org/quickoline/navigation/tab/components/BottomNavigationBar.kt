package org.quickoline.navigation.tab.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    selectedTabIndex: Int,
    onTabClicked: (Int) -> Unit
) {

    NavigationBar(modifier = modifier) {
        navigationTabs.forEachIndexed { tabIndex, tab ->
            NavigationBarItem(
                selected = selectedTabIndex == tabIndex,
                onClick = { onTabClicked(tabIndex) },
                icon = {
                    Icon(
                        imageVector = if (selectedTabIndex == tabIndex) tab.filledIcon else tab.outlinedIcon,
                        contentDescription = stringResource(tab.title),
                    )
                },
                label = {
                    Text(
                        text = stringResource(tab.title),
                        fontWeight = if (selectedTabIndex == tabIndex) FontWeight.ExtraBold else FontWeight.Medium
                    )
                }
            )
        }
    }
}