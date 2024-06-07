package org.quickoline.dashboard.navigation

import kotlinx.serialization.Serializable

@Serializable
internal sealed interface DashboardDestinations {

    @Serializable
    data object Home: DashboardDestinations

    @Serializable
    data class PostList(val category: String): DashboardDestinations

}