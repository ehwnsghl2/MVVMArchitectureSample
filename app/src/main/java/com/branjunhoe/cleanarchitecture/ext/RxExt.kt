package com.branjunhoe.cleanarchitecture.ext

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * RxJava2 subscribeOn, observeOn 공통
 * */
fun <T> Single<T>.mainThread(): Single<T> = subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
