package org.quickoline.onboarding.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.quickoline.utils.Constants.USER_ENTRY_KEY

internal class UserEntryManager(
    private val context: Context
) {

    private val entryKey = booleanPreferencesKey(USER_ENTRY_KEY)

    suspend fun saveUserEntryState() {
        context.dataStore.edit { data ->
            data[entryKey] = true
        }
    }

    fun getUserEntryState(): Flow<Boolean> {
        return context.dataStore.data.map { data ->
            data[entryKey] ?: false
        }
    }
}
