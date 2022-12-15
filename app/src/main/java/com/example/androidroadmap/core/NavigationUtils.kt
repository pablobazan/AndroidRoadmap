package com.example.androidroadmap.core

import android.content.Context
import android.content.Intent

object NavigationUtils {

    fun startActivity(context: Context, classToStart: Class<*>) {
        val intent = Intent(context, classToStart)
        context.startActivity(intent)
    }
}