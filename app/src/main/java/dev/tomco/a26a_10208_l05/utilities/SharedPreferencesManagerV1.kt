package dev.tomco.a26a_10208_l05.utilities

import android.content.Context

object SharedPreferencesManagerV1 {

    fun putString(context: Context, key: String, value: String){
        val sharedPreferences = context.getSharedPreferences(
            Constants.SP_KEYS.DATA_FILE,
            Context.MODE_PRIVATE
        ) ?: return
        with(sharedPreferences.edit()){
            putString(key,value)
            apply()
        }

    }

    fun getString(context: Context, key: String, defaultValue: String): String{
        val sharedPreferences = context.getSharedPreferences(
            Constants.SP_KEYS.DATA_FILE,
            Context.MODE_PRIVATE
        ) ?: return defaultValue
        return sharedPreferences
            .getString(
                key,
                defaultValue
            ) ?: defaultValue
    }
}