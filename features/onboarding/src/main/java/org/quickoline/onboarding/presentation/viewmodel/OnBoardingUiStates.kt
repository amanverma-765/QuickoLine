package org.quickoline.onboarding.presentation.viewmodel

import org.quickoline.utils.ApiResponse

internal data class OnBoardingUiStates(

    val policyAccepted: Boolean = false,
    val policyResponse: ApiResponse<Unit> = ApiResponse.Idle,
    val userEntryResponse: ApiResponse<Unit> = ApiResponse.Idle
)