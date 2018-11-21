package com.example.retina.todoclean.di

import android.arch.persistence.room.Room
import com.example.retina.todoclean.data.database.AppDatabase
import com.example.retina.todoclean.data.database.ItemDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module


val databaseModule = module {

    single { Room.databaseBuilder(androidApplication(),AppDatabase::class.java,"Item")
            .fallbackToDestructiveMigration()
            .build()
    }

    single{ get<AppDatabase>().getItemDao() }

}