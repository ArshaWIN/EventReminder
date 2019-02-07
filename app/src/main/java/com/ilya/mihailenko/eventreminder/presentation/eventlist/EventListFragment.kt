package com.ilya.mihailenko.eventreminder.presentation.eventlist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.ilya.mihailenko.eventreminder.R
import com.ilya.mihailenko.eventreminder.databinding.FragmentEventListBinding
import com.ilya.mihailenko.eventreminder.entity.Event
import com.ilya.mihailenko.eventreminder.presentation.eventlist.adapter.EventListAdapter
import com.ilya.mihailenko.eventreminder.presentation.eventlist.adapter.EventViewItem
import com.ilya.mihailenko.eventreminder.presentation.mvp.BaseFragment
import javax.inject.Inject


class EventListFragment : BaseFragment<FragmentEventListBinding>(), EventListView {

    @Inject
    @InjectPresenter
    lateinit var presenter: EventListPresenter

    @ProvidePresenter
    fun providePresenter(): EventListPresenter = presenter

    override val layoutRes: Int = R.layout.fragment_event_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener { presenter.onFabClick() }
        val adapter = EventListAdapter()
        binding.rvEvents.layoutManager = LinearLayoutManager(context)
        binding.rvEvents.adapter = adapter

    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    companion object {
        fun newInstance(): EventListFragment = EventListFragment()
    }
}