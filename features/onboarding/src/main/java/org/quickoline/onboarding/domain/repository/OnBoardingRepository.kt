package org.quickoline.onboarding.domain.repository

import kotlinx.coroutines.flow.Flow

interface OnBoardingRepository {

    suspend fun saveUserEntryState()
    fun getUserEntryState(): Flow<Boolean>

    suspend fun savePolicyState(state: Boolean)
    fun getPolicyState(): Flow<Boolean>
}