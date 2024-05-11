package org.quickoline.navigation.tabs

import kotlinx.serialization.Serializable

@Serializable
sealed interface TabDestinations {

    @Serializable
    data object HomeTab : TabDestinations

    @Serializable
    data object ActivityTab : TabDestinations
}

