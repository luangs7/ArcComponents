package com.example.retina.todoclean.adapter

import com.example.retina.todoclean.data.model.Item

interface OnClickRepository {
    fun onClickItem(item: Item)
}