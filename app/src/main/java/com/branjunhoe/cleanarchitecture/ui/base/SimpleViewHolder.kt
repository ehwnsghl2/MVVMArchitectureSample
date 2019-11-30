package com.branjunhoe.cleanarchitecture.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.branjunhoe.cleanarchitecture.BR
import com.branjunhoe.cleanarchitecture.BuildConfig


open class SimpleViewHolder(
    @LayoutRes layoutRes: Int,
    parent: ViewGroup?
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent?.context)
        .inflate(layoutRes, parent, false)
) {

    protected val binding: ViewDataBinding = DataBindingUtil.bind(itemView)!!

    open fun onBindViewHolder(item: Any?) {
        try {
            binding.run {
                setVariable(BR.item, item)
                executePendingBindings()
            }
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        }
    }
}
