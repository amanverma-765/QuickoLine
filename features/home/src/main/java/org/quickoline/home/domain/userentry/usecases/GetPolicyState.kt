package org.quickoline.home.domain.userentry.usecases

import kotlinx.coroutines.flow.Flow
import org.quickoline.onboarding.domain.repository.OnBoardingRepository

internal class GetPolicyState(
    private val onBoardingRepository: OnBoardingRepository
) {
    operator fun invoke(): Flow<Boolean> {
        return onBoardingRepository.getPolicyState()
    }
}