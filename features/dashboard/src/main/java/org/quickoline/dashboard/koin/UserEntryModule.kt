package org.quickoline.dashboard.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.quickoline.dashboard.presentation.viewmodel.userentry.UserEntryViewModel

val userEntryModule =  module {

    viewModel { params ->
        UserEntryViewModel(
            dataStoreUseCases = get(parameters = { params })
        )
    }
}