package com.example.retina.todoclean.adapter


import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.retina.todoclean.R
import com.example.retina.todoclean.data.model.Item

class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val tvName by lazy { view.findViewById(R.id.tvName) as TextView }
    val card by lazy { view.findViewById(R.id.card) as RelativeLayout }
    val tvLanguage by lazy { view.findViewById(R.id.tvLanguage) as TextView }

    fun bind(item: Item, clickRepository: OnClickRepository) {
        tvName.text = item.title

        card.setOnClickListener { clickRepository.onClickItem(item) }
    }
}
