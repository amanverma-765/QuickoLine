package org.quickoline.onboarding.domain.usecases

internal data class OnBoardingUseCases(

    val saveUserEntryState: SaveUserEntryState,
    val savePolicyState: SavePolicyState,
    val getUserEntryState: GetUserEntryState,
    val getPolicyState: GetPolicyState
)
