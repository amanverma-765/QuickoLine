package org.quickoline.dashboard.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.quickoline.dashboard.domain.userentry.usecases.GetPolicyState
import org.quickoline.dashboard.domain.userentry.usecases.GetUserEntryState
import org.quickoline.dashboard.domain.userentry.usecases.UserEntryUseCases
import org.quickoline.dashboard.presentation.viewmodel.userentry.UserEntryViewModel

val userEntryModule =  module {

    single {
        UserEntryUseCases(
            getUserEntryState = GetUserEntryState(onBoardingRepository = get()),
            getPolicyState = GetPolicyState(onBoardingRepository = get())
        )
    }

    viewModel { UserEntryViewModel(userEntryUseCases = get()) }
}