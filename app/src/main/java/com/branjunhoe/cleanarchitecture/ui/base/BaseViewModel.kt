package com.branjunhoe.cleanarchitecture.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    private val _addClicked = SingleLiveEvent<Any>()
    private val _finish = SingleLiveEvent<Any>()
    val _error = MutableLiveData<String>()

    val add: LiveData<Any> get() = _addClicked
    val finish: LiveData<Any> get() = _finish
    val error: LiveData<String> get() = _error

    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun finish() {
        _finish.call()
    }

    fun addClicked() {
        _addClicked.call()
    }


}