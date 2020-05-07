package com.branjunhoe.cleanarchitecture.di

import com.branjunhoe.cleanarchitecture.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { (userName: String) -> MainViewModel(userName, get()) }
}

