package org.quickoline.onboarding.presentation.viewmodel

internal sealed interface OnBoardingUiEvents {

    data object SaveUserEntryState: OnBoardingUiEvents
    data class SavePolicyState(val isAccepted: Boolean) : OnBoardingUiEvents
    data object CheckIfOnBoardingIsCompleted: OnBoardingUiEvents
}