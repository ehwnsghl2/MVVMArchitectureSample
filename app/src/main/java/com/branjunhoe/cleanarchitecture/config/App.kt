package com.branjunhoe.cleanarchitecture.config

import android.app.Application
import com.daangn.www.mvvmsample.di.apiModule
import com.daangn.www.mvvmsample.di.viewModelModule
import com.peppy.peppy.di.networkModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(networkModule, viewModelModule, apiModule))
    }
}