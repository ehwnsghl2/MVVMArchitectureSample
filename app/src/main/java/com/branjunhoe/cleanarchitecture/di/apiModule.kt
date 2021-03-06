package com.branjunhoe.cleanarchitecture.di

import com.branjunhoe.cleanarchitecture.ui.main.MainViewModel
import com.peppy.peppy.api.repository.ReposRepository
import com.peppy.peppy.api.repository.ReposRepositoryImpl
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val apiModule = module {
    single { ReposRepositoryImpl(get()) as ReposRepository}
}
