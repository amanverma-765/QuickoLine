package org.quickoline.home.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.quickoline.home.domain.userentry.usecases.GetPolicyState
import org.quickoline.home.domain.userentry.usecases.GetUserEntryState
import org.quickoline.home.domain.userentry.usecases.UserEntryUseCases
import org.quickoline.home.presentation.viewmodel.userentry.UserEntryViewModel

val userEntryModule =  module {

    single {
        UserEntryUseCases(
            getUserEntryState = GetUserEntryState(onBoardingRepository = get()),
            getPolicyState = GetPolicyState(onBoardingRepository = get())
        )
    }

    viewModel { UserEntryViewModel(userEntryUseCases = get()) }
}