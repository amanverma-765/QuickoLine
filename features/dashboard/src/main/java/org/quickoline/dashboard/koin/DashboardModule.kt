package org.quickoline.dashboard.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.quickoline.dashboard.presentation.viewmodel.home.HomeViewModel
import org.quickoline.dashboard.presentation.viewmodel.post.PostViewModel
import org.quickoline.dashboard.presentation.viewmodel.userentry.UserEntryViewModel

val dashboardModule =  module {

    viewModel { params ->
        UserEntryViewModel(
            dataStoreUseCases = get(parameters = { params })
        )
    }

    viewModel {
        PostViewModel(
            publicPostDataUseCases = get()
        )
    }

    viewModel {
        HomeViewModel(
            publicPostDataUseCases = get()
        )
    }
}