package com.peppy.peppy.api.repository

import com.branjunhoe.cleanarchitecture.data.model.Repos
import io.reactivex.Single

interface ReposRepository {
    fun repos(username: String): Single<MutableList<Repos>>
}