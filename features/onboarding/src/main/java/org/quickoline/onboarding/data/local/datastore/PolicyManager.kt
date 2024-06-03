package org.quickoline.onboarding.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.quickoline.utils.Constants.POLICY_KEY

internal class PolicyManager(
    private val context: Context
) {

    private val policyKey = booleanPreferencesKey(POLICY_KEY)

    suspend fun savePolicyState(state: Boolean) {
        context.dataStore.edit { data ->
            data[policyKey] = state
        }
    }

    fun getPolicyState(): Flow<Boolean> {
        return context.dataStore.data.map { data ->
            data[policyKey] ?: false
        }
    }
}

