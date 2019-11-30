package com.branjunhoe.cleanarchitecture.network

import com.branjunhoe.cleanarchitecture.data.model.Repos
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("/users/{username}/repos")
    fun repos(@Path("username") username: String): Single<MutableList<Repos>>

}