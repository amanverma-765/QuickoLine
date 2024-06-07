package org.quickoline.dashboard.domain.userentry.usecases

import kotlinx.coroutines.flow.Flow
import org.quickoline.onboarding.domain.repositories.OnBoardingRepository

internal class GetUserEntryState(
    private val onBoardingRepository: OnBoardingRepository
) {
    operator fun invoke(): Flow<Boolean> {
        return onBoardingRepository.getUserEntryState()
    }
}