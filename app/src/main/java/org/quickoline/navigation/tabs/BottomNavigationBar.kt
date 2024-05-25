package org.quickoline.navigation.tabs

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
    selectedTab: NavItem,
    onTabClicked: (Any) -> Unit,
) {

//    val backStack = tabNavigator.currentBackStackEntryAsState()
//    val destination = backStack.value?.destination

//    val selectedTab = remember(destination) {
//        navigationTabs.find { tab ->
//            destination?.hasRoute(tab.destination::class) == true
//        }
//    }

    NavigationBar(modifier = modifier) {
        navigationTabs.forEach { tab ->

            NavigationBarItem(
                modifier = Modifier,
                selected = selectedTab == tab,
                onClick = { onTabClicked(tab.destination) },
                icon = {
                    Icon(
                        imageVector = if (selectedTab == tab) tab.filledIcon else tab.outlinedIcon,
                        contentDescription = stringResource(tab.title),
                    )
                },
                label = {
                    Text(
                        text = stringResource(tab.title),
                        fontWeight = if (selectedTab == tab) FontWeight.ExtraBold else FontWeight.Medium
                    )
                }
            )
        }
    }
}