package com.example.retina.todoclean.data.database

import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.arch.persistence.room.*
import android.content.Context
import com.example.retina.todoclean.data.model.Item

@Database(entities = [Item::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getItemDao() : ItemDao

}