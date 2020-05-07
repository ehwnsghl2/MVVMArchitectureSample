package com.branjunhoe.cleanarchitecture.core

import android.app.Application
import com.branjunhoe.cleanarchitecture.di.apiModule
import com.branjunhoe.cleanarchitecture.di.viewModelModule
import com.branjunhoe.cleanarchitecture.di.networkModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(
            networkModule,
            viewModelModule,
            apiModule
        ))
    }
}