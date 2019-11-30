package com.daangn.www.mvvmsample.di

import com.branjunhoe.cleanarchitecture.ui.main.MainViewModel
import com.peppy.peppy.api.repository.ReposRepository
import com.peppy.peppy.api.repository.ReposRepositoryImpl
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

