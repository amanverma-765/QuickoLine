package org.quickoline.dashboard.domain.userentry.usecases

internal data class UserEntryUseCases(
    val getUserEntryState: GetUserEntryState,
    val getPolicyState: GetPolicyState
)