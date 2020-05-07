package com.peppy.peppy.api.repository

import com.branjunhoe.cleanarchitecture.data.model.Repos
import com.branjunhoe.cleanarchitecture.remote.ApiService
import io.reactivex.Single

class ReposRepositoryImpl(private val apiService: ApiService) : ReposRepository {

    override fun repos(username: String): Single<MutableList<Repos>> {
        return apiService.repos(username)
    }

}