package com.example.retina.todoclean.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.retina.todoclean.R
import com.example.retina.todoclean.data.model.Item

class RepoAdapter constructor(private var repositories: ArrayList<Item>?,
                              private val clickRepository: OnClickRepository)
    : RecyclerView.Adapter<RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_item_row, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        repositories?.let {
            val repository = it[position]
            holder.bind(repository, clickRepository)
        }
    }


    fun addItens(itens: List<Item>) {
        repositories?.let {
            it.clear()
            it.addAll(itens)
        } ?: initList(itens)
    }

    private fun initList(itens: List<Item>) {
        repositories = itens.toCollection(ArrayList())
    }

    override fun getItemCount(): Int {
        repositories?.let {
            return it.size
        } ?: return 0
    }

}
