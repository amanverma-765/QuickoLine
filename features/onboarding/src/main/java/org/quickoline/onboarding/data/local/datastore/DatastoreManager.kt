package org.quickoline.onboarding.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import org.quickoline.utils.Constants

internal val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = Constants.USER_ENTRY)
