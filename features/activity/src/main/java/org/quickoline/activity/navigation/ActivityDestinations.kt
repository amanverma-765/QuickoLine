package org.quickoline.activity.navigation

import kotlinx.serialization.Serializable

@Serializable
internal sealed interface ActivityDestinations {

    @Serializable
    data object Activity: ActivityDestinations
}