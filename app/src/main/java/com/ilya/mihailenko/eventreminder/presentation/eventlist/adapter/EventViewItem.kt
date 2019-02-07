package com.ilya.mihailenko.eventreminder.presentation.eventlist.adapter

import com.ilya.mihailenko.eventreminder.R
import com.ilya.mihailenko.eventreminder.databinding.ItemEventBinding
import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.ui.adapter.DataBindingViewHolder
import com.ilya.mihailenko.eventreminder.ui.adapter.ViewItem


class EventViewItem(
    val event: Event
) : ViewItem<ItemEventBinding>, EventViewModel {

    override fun getLayoutId(): Int = R.layout.item_event

    override fun bind(holder: DataBindingViewHolder<ItemEventBinding>) {
        holder.binding.viewModel = this
    }

    override fun getEventTitle(): String  = event.name

    override fun getEventDescription(): String = event.description

    override fun getEventDate(): String = "10/12/2028"
}