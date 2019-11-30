package com.peppy.peppy.di

import com.branjunhoe.cleanarchitecture.BuildConfig
import com.branjunhoe.cleanarchitecture.config.baseUrl
import com.branjunhoe.cleanarchitecture.config.headerInterceptor
import com.branjunhoe.cleanarchitecture.config.loggingInterceptor
import com.branjunhoe.cleanarchitecture.network.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(get(headerInterceptor))
                    .addInterceptor(get(loggingInterceptor))
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(ApiService::class.java)
    }


    single(headerInterceptor) {
        Interceptor { chain ->
            val builder = chain.request().newBuilder().apply {
                header("Content-Type", "application/json")
                header("Accept", "application/json")
            }
            chain.proceed(builder.build())
        }
    }

    single(loggingInterceptor) {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        } as Interceptor
    }

}

