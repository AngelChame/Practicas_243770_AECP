package com.angel.practicarandroidstudio.DataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
class StoreUserProfile (private val context: Context){

    companion object {
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("UserProfile")
        private val USER_EMAIL = stringPreferencesKey("user_email")
        private val USER_NAME = stringPreferencesKey("user_name")
        private val USER_PHONE = stringPreferencesKey("user_phone")
        private val USER_AGE = stringPreferencesKey("user_age")
    }

    val getEmail: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[USER_EMAIL] ?:""
        }

    val getName: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[USER_NAME] ?:""
        }

    val getPhone: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[USER_PHONE] ?:""
        }

    val getAge: Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[USER_AGE] ?: ""
        }

    suspend fun saveEmail(email: String){
        context.dataStore.edit { preferences ->
            preferences[USER_EMAIL] = email
        }
    }

    suspend fun saveUserProfile(email: String, name: String, phone: String, age: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_EMAIL] = email
            preferences[USER_NAME] = name
            preferences[USER_PHONE] = phone
            preferences[USER_AGE] = age
        }
    }

}