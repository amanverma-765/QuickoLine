package org.quickoline.onboarding.koin

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.quickoline.onboarding.data.local.datastore.PolicyManager
import org.quickoline.onboarding.data.local.datastore.UserEntryManager
import org.quickoline.onboarding.data.local.repository.OnBoardingRepositoryImpl
import org.quickoline.onboarding.domain.repository.OnBoardingRepository
import org.quickoline.onboarding.domain.usecases.OnBoardingUseCases
import org.quickoline.onboarding.domain.usecases.SavePolicyState
import org.quickoline.onboarding.domain.usecases.SaveUserEntryState
import org.quickoline.onboarding.presentation.viewmodel.OnBoardingViewModel

val onBoardingModule = module {

    single { UserEntryManager(androidContext()) }
    single { PolicyManager(androidContext()) }

    single<OnBoardingRepository> {
        OnBoardingRepositoryImpl(
            userEntryManager = get(),
            policyManager = get()
        )
    }

    single {
        OnBoardingUseCases(
            saveUserEntryState = SaveUserEntryState(onBoardingRepository = get()),
            savePolicyState = SavePolicyState(onBoardingRepository = get()),
        )
    }

    viewModel { OnBoardingViewModel(onBoardingUseCases = get()) }
}