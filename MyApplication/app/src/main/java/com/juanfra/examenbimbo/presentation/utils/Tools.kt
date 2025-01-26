package com.juanfra.examenbimbo.presentation.utils

import android.app.Activity
import android.content.Context
import com.juanfra.examenbimbo.R

fun Activity.savePreferences(name: String){
    val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
    with (sharedPref.edit()) {
        putString(getString(R.string.saved_name), name)
        apply()
    }
}

fun Activity.getPreference(): String{
    val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return ""
    val name = sharedPref.getString(getString(R.string.saved_name), "")
    return name ?: ""
}