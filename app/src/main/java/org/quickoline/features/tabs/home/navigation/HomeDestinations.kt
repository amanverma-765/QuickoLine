package org.quickoline.features.tabs.home.navigation

import kotlinx.serialization.Serializable

@Serializable
internal sealed interface HomeDestinations {

    @Serializable
    data object Home: HomeDestinations

}