package com.branjunhoe.cleanarchitecture.ext

import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.branjunhoe.cleanarchitecture.ui.base.SimpleRvAdapter

/**
 * 리사이클러뷰 데이터 주입
 * */
@BindingAdapter(value = ["replaceAll"])
fun RecyclerView.replaceAll(items: List<Any>?) {
    (adapter as? SimpleRvAdapter)?.replaceAll(items)
}

/**
 *  RecyclerView Adapter 생성 및 데이터 주입
 * */
@Suppress("UNCHECKED_CAST")
@BindingAdapter(value = ["itemLayout", "items"])
fun RecyclerView.SimpleRvAdapter(
    @LayoutRes adapterItemId: Int,
    items: List<Any>?
) {
    val simpleAdapter =
        (adapter as? SimpleRvAdapter) ?: SimpleRvAdapter(adapterItemId).also {
            this.adapter = it
        }
    simpleAdapter.replaceAll(items)
    addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
}

