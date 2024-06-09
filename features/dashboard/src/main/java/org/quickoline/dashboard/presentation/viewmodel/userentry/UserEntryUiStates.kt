package org.quickoline.dashboard.presentation.viewmodel.userentry

import org.quickoline.utils.ApiResponse

internal data class UserEntryUiStates(

    val policyResponse: ApiResponse<Boolean>? = null,
    val userEntryResponse: ApiResponse<Boolean>? = null

)