package org.quickoline.dashboard.navigation

import kotlinx.serialization.Serializable
import org.quickoline.domain.model.post.PublicPostData

@Serializable
internal sealed interface DashboardDestinations {

    @Serializable
    data object Home: DashboardDestinations

    @Serializable
    data class PostList(val category: String): DashboardDestinations

    @Serializable
    data object PostDetail: DashboardDestinations

}