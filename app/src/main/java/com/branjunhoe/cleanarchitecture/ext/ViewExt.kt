package com.branjunhoe.cleanarchitecture.ext

import android.view.View
import androidx.databinding.BindingAdapter
import com.jakewharton.rxbinding2.view.RxView
import java.util.concurrent.TimeUnit

/**
 * 버튼 클릭 중복 처리 (2초)
 * */
@BindingAdapter(value = ["onBlockClick"])
fun View.setOnBlockClick(listener: View.OnClickListener) {
    RxView.clicks(this)
        .throttleFirst(2, TimeUnit.SECONDS)
        .subscribe {
            listener.onClick(this)
        }
}



