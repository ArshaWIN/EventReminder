package com.ilya.mihailenko.eventreminder.ui.adapter

import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes

interface ViewItem<T : ViewDataBinding> {
    @LayoutRes
    fun getLayoutId(): Int

    fun bind(holder: DataBindingViewHolder<T>)
}
