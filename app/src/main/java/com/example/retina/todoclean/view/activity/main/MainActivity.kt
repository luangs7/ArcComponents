package com.example.retina.todoclean.view.activity.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.com.luan2.lgutilsk.utils.runAsync
import com.example.retina.todoclean.R
import com.example.retina.todoclean.adapter.OnClickRepository
import com.example.retina.todoclean.adapter.RepoAdapter
import com.example.retina.todoclean.data.model.Item
import com.example.retina.todoclean.data.model.ItemViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity(), MainActivityContract.View, OnClickRepository {

    val presenter: MainActivityPresenter by inject()
    val viewModel: ItemViewModel by viewModel()
    var adapter: RepoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = RepoAdapter(null, this)


        presenter.injectView(this)

        button.setOnClickListener {
            val id = (1..99).random()
            GlobalScope.launch {
                val item = Item(id, "Abc $id", true)
                presenter.saveItem(item)
            }
        }
    }

    override fun showError(error: String) {
        showError(error)
    }

    override fun onListUpdate(itens: List<Item>) {

    }

    override fun hideKeyboard() {

    }

    override fun showProgress(message: String?) {

    }

    override fun hideProgress() {

    }

    override fun bindViews() {
        val llm = LinearLayoutManager(this@MainActivity)
        llm.orientation = LinearLayoutManager.VERTICAL
        lista.layoutManager = llm

        lista.adapter = adapter

        viewModel.innerResult.observe(this, Observer {
            adapter?.addItens(it!!)
            adapter?.notifyDataSetChanged()
        })


    }


    override fun onClickItem(item: Item) {
        presenter.setItemClose(item)
    }
}

fun IntRange.random() =
        Random().nextInt((endInclusive + 1) - start) +  start


