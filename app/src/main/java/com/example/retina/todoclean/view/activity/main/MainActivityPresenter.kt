package com.example.retina.todoclean.view.activity.main

import br.com.luan2.lgutilsk.utils.runAsync
import com.example.retina.todoclean.data.model.Item
import com.example.retina.todoclean.data.model.ItemViewModel


class MainActivityPresenter(val viewModel: ItemViewModel) : MainActivityContract.Presenter {
    lateinit var view: MainActivityContract.View

    fun injectView(view: MainActivityContract.View) {
        this.view = view
        view.bindViews()
    }

    override fun saveItem(item: Item) {
        runAsync {
            viewModel.saveItem(item)
        }

//        updateList(viewModel.innerResult.value!!)
    }

    override fun getItemDetails(item: Item) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setItemClose(item: Item) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateList(itens: List<Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}