package com.branjunhoe.cleanarchitecture.ext

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * 프래그먼트 트랜잭션
 * */
fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commitAllowingStateLoss()
}
