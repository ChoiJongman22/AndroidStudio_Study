package com.jongman22.todolistapp

import android.app.Application

class App:Application() {
    companion object{
        lateinit var prefs:MysharedPreferences
    }

    override fun onCreate() {
        prefs =MysharedPreferences(applicationContext)
        super.onCreate()
    }

}