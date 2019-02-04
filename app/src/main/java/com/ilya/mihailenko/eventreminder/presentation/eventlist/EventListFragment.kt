package com.ilya.mihailenko.eventreminder.presentation.eventlist

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.ilya.mihailenko.eventreminder.R
import com.ilya.mihailenko.eventreminder.databinding.FragmentEventListBinding
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
        binding.tvText.text = "TestTestKNF klfwme qdwm"
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    companion object {
        fun newInstance(): EventListFragment = EventListFragment()
    }
}