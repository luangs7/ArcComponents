package com.example.retina.todoclean.view.activity.main

import com.example.retina.todoclean.data.model.Item

interface MainActivityContract {

    interface Presenter{
        fun saveItem(item: Item)
        fun getItemDetails(item:Item)
        fun setItemClose(item: Item)
        fun updateList(itens:List<Item>)

    }


    interface View{
        fun showError(error: String)
        fun onListUpdate(itens:List<Item>)
        fun hideKeyboard()
        fun showProgress(message:String? = "Buscando dados")
        fun hideProgress()
        fun bindViews()

    }


}