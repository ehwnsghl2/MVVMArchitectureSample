package com.branjunhoe.cleanarchitecture.ui.base

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

open class SimpleRvAdapter(
    @LayoutRes private val layoutRes: Int
) : RecyclerView.Adapter<SimpleViewHolder>() {

    protected open val items = mutableListOf<Any>()

    open fun replaceAll(items: List<Any>?) {
        this.items.run {
            clear()
            items?.let {
                addAll(it)
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SimpleViewHolder(layoutRes = layoutRes, parent = parent)

    override fun getItemCount() =
        items.size

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) =
        holder.onBindViewHolder(items[position])
}
