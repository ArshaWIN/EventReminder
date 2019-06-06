package com.ilya.mihailenko.eventreminder.presentation.eventlist.adapter

import com.ilya.mihailenko.eventreminder.R
import com.ilya.mihailenko.eventreminder.databinding.ItemEventBinding
import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.ui.adapter.DataBindingViewHolder
import com.ilya.mihailenko.eventreminder.ui.adapter.ViewItem
import com.ilya.mihailenko.eventreminder.ui.adapter.diffutil.ContentComparable
import com.ilya.mihailenko.eventreminder.utils.ext.toReadableDateTime

class EventViewItem(
    private val event: Event
) : ViewItem<ItemEventBinding>, EventViewModel, ContentComparable<EventViewItem> {

    override fun getLayoutId(): Int = R.layout.item_event

    override fun bind(holder: DataBindingViewHolder<ItemEventBinding>) {
        holder.binding.viewModel = this
    }

    override fun getEventTitle(): String = event.name

    override fun getEventDescription(): String = event.description

    override fun getEventDate(): String = event.reminderDate.toReadableDateTime()

    override fun areContentsTheSame(another: EventViewItem): Boolean =
        event == another.event

    override fun areItemsTheSame(another: EventViewItem): Boolean =
        event.id == another.event.id
}