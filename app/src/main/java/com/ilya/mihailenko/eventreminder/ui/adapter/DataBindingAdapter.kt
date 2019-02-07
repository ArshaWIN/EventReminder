package com.ilya.mihailenko.eventreminder.ui.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import java.util.ArrayList

/**
 * Base adapter for simple list of ViewModels
 */
open class DataBindingAdapter<B : ViewDataBinding, V : ViewItem<B>> :
    RecyclerView.Adapter<DataBindingViewHolder<B>>() {

    var items: MutableList<V> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun addItems(items: List<V>) {
        val startIndex = this.items.size
        this.items.addAll(items)
        if (startIndex == 0) {
            notifyDataSetChanged()
        } else {
            notifyItemRangeInserted(startIndex, items.size)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<B> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<B>(inflater, viewType, parent, false)
        return DataBindingViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int = items[position].getLayoutId()

    override fun onBindViewHolder(holder: DataBindingViewHolder<B>, position: Int) {
        items[position].bind(holder)
    }

    override fun getItemCount(): Int = items.size
}
