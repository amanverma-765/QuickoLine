package org.quickoline.navigation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.quickoline.navigation.tabs.navigationTabs

class NavViewModel : ViewModel() {

    private val _selectedTab = MutableStateFlow(navigationTabs[0])
    val selectedTab = _selectedTab.asStateFlow()

    private val _shouldShowBottomBar = MutableStateFlow(false)
    val shouldShowBottomBar = _shouldShowBottomBar.asStateFlow()

    fun destinationChanged(destination: NavDestination) {

        val selected = navigationTabs.find { tab ->
            destination.parent?.hasRoute(tab.destination::class) == true
        }

        selected?.let {
            _selectedTab.value = selected
        }
    }
}
