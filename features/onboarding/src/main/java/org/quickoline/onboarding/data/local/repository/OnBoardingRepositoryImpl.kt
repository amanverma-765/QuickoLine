package org.quickoline.onboarding.data.local.repository

import kotlinx.coroutines.flow.Flow
import org.quickoline.onboarding.data.local.datastore.PolicyManager
import org.quickoline.onboarding.data.local.datastore.UserEntryManager
import org.quickoline.onboarding.domain.repositories.OnBoardingRepository

internal class OnBoardingRepositoryImpl(
    private val userEntryManager: UserEntryManager,
    private val policyManager: PolicyManager
) : OnBoardingRepository {

    override suspend fun saveUserEntryState() {
        userEntryManager.saveUserEntryState()
    }

    override fun getUserEntryState(): Flow<Boolean> {
        return userEntryManager.getUserEntryState()
    }

    override suspend fun savePolicyState(state: Boolean) {
        policyManager.savePolicyState(state)
    }

    override fun getPolicyState(): Flow<Boolean> {
        return policyManager.getPolicyState()
    }

}