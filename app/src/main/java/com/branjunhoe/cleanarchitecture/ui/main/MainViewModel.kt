package com.branjunhoe.cleanarchitecture.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.branjunhoe.cleanarchitecture.ext.with
import com.branjunhoe.cleanarchitecture.data.model.Repos
import com.branjunhoe.cleanarchitecture.ui.base.BaseViewModel
import com.peppy.peppy.api.repository.ReposRepository

class MainViewModel(private val repository: ReposRepository) : BaseViewModel() {

    private val _repos = MutableLiveData<MutableList<Repos>>()

    val repos: LiveData<MutableList<Repos>> get() = _repos

    init {
        getRepos("ehwnsghl2")
    }


    private fun getRepos(username: String) {
        addDisposable(
            repository.repos(username)
                .with()
                .subscribe({
                    _repos.value = it
                }, {
                    _error.value = it.message
                })
        )
    }


}