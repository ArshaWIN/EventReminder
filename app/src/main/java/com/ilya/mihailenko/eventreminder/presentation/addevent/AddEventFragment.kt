package com.ilya.mihailenko.eventreminder.presentation.addevent

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.ilya.mihailenko.eventreminder.R
import com.ilya.mihailenko.eventreminder.databinding.FragmentAddEventBinding
import com.ilya.mihailenko.eventreminder.presentation.mvp.BaseFragment
import javax.inject.Inject


class AddEventFragment : BaseFragment<FragmentAddEventBinding>(), AddEventView {

    @Inject
    @InjectPresenter
    lateinit var presenter: AddEventPresenter

    @ProvidePresenter
    fun providePresenter(): AddEventPresenter = presenter

    override val layoutRes: Int = R.layout.fragment_add_event

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    companion object {
        fun newInstance(): AddEventFragment = AddEventFragment()
    }

}