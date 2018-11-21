package com.example.retina.todoclean.data.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.retina.todoclean.data.model.Item
import kotlinx.coroutines.Deferred


@Dao
interface ItemDao {

    @Query("SELECT * FROM ItemTodo")
    fun getAll(): LiveData<List<Item>>

    @Query("SELECT * FROM ItemTodo WHERE ItemTodo.id = :id")
    fun getId(id:Int): LiveData<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg itens: Item)

    @Delete
    fun delete(item: Item)


}