package com.example.retina.todoclean.view.activity.main

import br.com.luan2.lgutilsk.utils.runAsync
import com.example.retina.todoclean.data.model.Item
import com.example.retina.todoclean.data.model.ItemViewModel


class MainActivityPresenter(val viewModel: ItemViewModel) : MainActivityContract.Presenter {
    lateinit var view: MainActivityContract.View

    fun injectView(view: MainActivityContract.View) {
        this.view = view
        view.bindViews()

        runAsync {
            viewModel.deleteAll()
        }
    }

    override fun saveItem(item: Item) {
        runAsync {
            viewModel.saveItem(item)
        }

//        updateList(viewModel.innerResult.value!!)
    }

    override fun getItemDetails(item: Item) {

    }

    override fun setItemClose(item: Item) {
        runAsync {
            viewModel.saveItem(item)
        }
    }

    override fun updateList(itens: List<Item>) {

    }
}