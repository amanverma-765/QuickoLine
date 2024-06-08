package org.quickoline.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BooleanDataStoreManager(
    private val context: Context,
    preferenceName: String
) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = preferenceName)
//    private val booleanKey = booleanPreferencesKey(key)
    suspend fun saveData(data: Boolean?, key: String) {
        context.dataStore.edit { store ->
            store[booleanPreferencesKey(key)] = data ?: true
        }
    }

    fun getData(key: String): Flow<Boolean> {
        return context.dataStore.data.map { data ->
            data[booleanPreferencesKey(key)] ?: false
        }
    }
}
