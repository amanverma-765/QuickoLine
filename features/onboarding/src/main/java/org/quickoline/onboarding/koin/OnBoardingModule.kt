package org.quickoline.onboarding.koin

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.quickoline.onboarding.presentation.viewmodel.OnBoardingViewModel

val onBoardingModule = module {

//    single { UserEntryManager(androidContext()) }
//    single { PolicyManager(androidContext()) }
//
//    single<OnBoardingRepository> {
//        OnBoardingRepositoryImpl(
//            userEntryManager = get(),
//            policyManager = get()
//        )
//    }
//
//    single {
//        OnBoardingUseCases(
//            saveUserEntryState = SaveUserEntryState(onBoardingRepository = get()),
//            savePolicyState = SavePolicyState(onBoardingRepository = get()),
//        )
//    }

    viewModel { params ->
        OnBoardingViewModel(
            dataStoreUseCases = get(parameters = { params })
        )
    }
}