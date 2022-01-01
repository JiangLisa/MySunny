package com.j.my_sunny

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context:Context
        const val TOKEN="rDovNRuIInGwXU1o"
    }

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}