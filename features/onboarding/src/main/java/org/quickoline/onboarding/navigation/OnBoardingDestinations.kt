package org.quickoline.onboarding.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface OnBoardingDestinations {

    @Serializable
    data object Welcome : OnBoardingDestinations
}