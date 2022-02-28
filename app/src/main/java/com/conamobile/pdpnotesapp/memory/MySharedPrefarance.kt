package com.conamobile.pdpnotesapp.memory

import android.content.Context
import androidx.core.content.edit
import java.util.function.DoubleToIntFunction
import java.util.function.LongToDoubleFunction

class MySharedPrefarance(context: Context) {
    private val pref = context.getSharedPreferences("nimadir", Context.MODE_PRIVATE)

    fun isSavedList(isSavedVoice: String){
        val editor = pref.edit()
        editor.putString("isSavedVoice", isSavedVoice)
        editor.apply()
    }

    fun getSavedList():String?{
        return pref.getString("isSavedVoice","")
    }

}