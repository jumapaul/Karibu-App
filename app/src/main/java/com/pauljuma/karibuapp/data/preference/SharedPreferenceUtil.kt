package com.pauljuma.karibuapp.data.preference

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceUtil(activity: Context) {
    val sharedPreference: SharedPreferences = activity.getSharedPreferences("Karibu_prefence", Context.MODE_PRIVATE)

    fun save(key: String, data: String) {
        with(sharedPreference.edit()) {
            putString(key, data)
            apply()
        }
    }

    fun save(key: String, data: Int) {
        with(sharedPreference.edit()) {
            putInt(key, data)
            apply()
        }
    }

    fun save(key: String, data: Float) {
        with(sharedPreference.edit()) {
            putFloat(key, data)
            apply()
        }
    }

    fun save(key: String, data: Boolean) {
        with(sharedPreference.edit()) {
            putBoolean(key, data)
            apply()
        }
    }

    fun getString(key: String): String {
        return sharedPreference.getString(key, "") ?: ""
    }

    fun getInt(key: String): Int {
        return sharedPreference.getInt(key, 0)
    }

    fun getBoolean(key: String): Boolean {
        return sharedPreference.getBoolean(key, false)
    }

    fun getFloat(key: String): Float {
        return sharedPreference.getFloat(key, 0f)
    }
}