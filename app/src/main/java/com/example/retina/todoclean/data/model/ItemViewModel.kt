package com.example.retina.todoclean.data.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.retina.todoclean.data.BaseViewModel
import com.example.retina.todoclean.data.database.ItemDao
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ItemViewModel(val dao: ItemDao): BaseViewModel() {

    val innerRepositoryResult = MutableLiveData<List<Item>>()

    val innerResult
        get() = dao.getAll()


    fun saveItem(item: Item){
        dao.insertAll(item)

//        innerRepositoryResult.postValue(dao.getAll())
    }

}