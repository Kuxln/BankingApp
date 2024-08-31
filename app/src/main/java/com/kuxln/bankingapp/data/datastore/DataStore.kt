package com.kuxln.bankingapp.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

const val PREFERENCES_NAME = "ACCOUNT"

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

@Singleton
class DataStore @Inject constructor(
    private val context: Context
) {

    val clientIdFlow: Flow<Int?> = context.dataStore.data
        .map { preferences ->
            preferences[EXAMPLE_COUNTER]
        }

    suspend fun saveClientId(clientId: Int) {
        context.dataStore.edit { preferences ->
            preferences[EXAMPLE_COUNTER] = clientId
        }
    }

    companion object {
        private val EXAMPLE_COUNTER = intPreferencesKey("client_id")
    }
}