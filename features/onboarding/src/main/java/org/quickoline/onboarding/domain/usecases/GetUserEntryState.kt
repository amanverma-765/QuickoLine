package org.quickoline.onboarding.domain.usecases

import kotlinx.coroutines.flow.Flow
import org.quickoline.onboarding.domain.repository.OnBoardingRepository

internal class GetUserEntryState(
    private val onBoardingRepository: OnBoardingRepository
) {
    operator fun invoke(): Flow<Boolean> {
        return onBoardingRepository.getUserEntryState()
    }
}