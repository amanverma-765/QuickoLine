package org.quickoline.onboarding.domain.usecases

import org.quickoline.onboarding.domain.repositories.OnBoardingRepository

internal class SaveUserEntryState(
    private val onBoardingRepository: OnBoardingRepository
) {
    suspend operator fun invoke() {
        onBoardingRepository.saveUserEntryState()
    }
}