package org.quickoline.navigation.root

import kotlinx.serialization.Serializable

internal sealed interface RootDestinations {

    @Serializable
    data object OnBoardingGraph: RootDestinations

    @Serializable
    data object TabGraph: RootDestinations
}