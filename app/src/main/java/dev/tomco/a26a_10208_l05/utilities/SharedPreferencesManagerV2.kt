package dev.tomco.a26a_10208_l05.utilities

import android.content.Context

class SharedPreferencesManagerV2(context: Context) {
    private val sharedPreferences = context.getSharedPreferences(
        Constants.SP_KEYS.DATA_FILE,
        Context.MODE_PRIVATE
    )


    fun putString( key: String, value: String){
        with(sharedPreferences.edit()){
            putString(key,value)
            apply()
        }

    }

    fun getString( key: String, defaultValue: String): String{
        return sharedPreferences
            .getString(
                key,
                defaultValue
            ) ?: defaultValue
    }
}