package com.example.retina.todoclean


import android.app.Application
import com.example.retina.todoclean.di.appModule
import com.example.retina.todoclean.di.databaseModule
import org.koin.android.ext.android.startKoin


class App : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule, databaseModule))
    }

}