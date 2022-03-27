package com.example.cocktails

import android.app.Application
import com.example.cocktails.di.AppComponent

class App: Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
    }
}