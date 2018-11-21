package com.example.retina.todoclean.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.retina.todoclean.data.BaseViewModel


@Entity(tableName = "ItemTodo")
data class Item (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "is_open")
    var isOpen: Boolean = true

)