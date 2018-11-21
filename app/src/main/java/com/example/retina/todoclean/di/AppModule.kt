package com.example.retina.todoclean.di

import com.example.retina.todoclean.data.database.ItemDao
import com.example.retina.todoclean.data.model.ItemViewModel
import com.example.retina.todoclean.view.activity.main.MainActivityPresenter
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val appModule = module {
    viewModel { ItemViewModel(get() as ItemDao) }

    single { MainActivityPresenter(get() as ItemViewModel) }
}