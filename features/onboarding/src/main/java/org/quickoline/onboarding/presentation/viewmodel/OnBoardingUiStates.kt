package org.quickoline.onboarding.presentation.viewmodel

import org.quickoline.utils.ApiResponse

internal data class OnBoardingUiStates(

    val policyAccepted: Boolean = false,
    val policyResponse: ApiResponse<Unit>? = null,
    val userEntryResponse: ApiResponse<Unit>? = null
)