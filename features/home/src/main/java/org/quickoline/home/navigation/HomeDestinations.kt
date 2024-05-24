package org.quickoline.home.navigation

import kotlinx.serialization.Serializable

@Serializable
internal sealed interface HomeDestinations {

    @Serializable
    data object Home: HomeDestinations

    @Serializable
    data object PostList: HomeDestinations

}