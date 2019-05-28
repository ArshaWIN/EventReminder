package com.ilya.mihailenko.eventreminder.presentation.addevent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.ilya.mihailenko.eventreminder.R
import com.ilya.mihailenko.eventreminder.databinding.FragmentAddEventBinding
import com.ilya.mihailenko.eventreminder.presentation.mvp.BaseFragment
import com.ilya.mihailenko.eventreminder.presentation.pickdate.*
import com.ilya.mihailenko.eventreminder.utils.DialogUtils
import com.ilya.mihailenko.eventreminder.utils.ext.hideKeyboard
import org.joda.time.DateTime
import timber.log.Timber
import javax.inject.Inject


class AddEventFragment : BaseFragment<FragmentAddEventBinding>(), AddEventView,
    OnDateTimeChangeListener, AddEventViewModel.Handler {

    @Inject
    @InjectPresenter
    lateinit var presenter: AddEventPresenter

    @ProvidePresenter
    fun providePresenter(): AddEventPresenter = presenter

    private val viewModel by lazy { AddEventViewModelImpl() }

    override val layoutRes: Int = R.layout.fragment_add_event

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.handler = this
    }

    override fun onSaveClick() {
        presenter.onSaveClick(
            binding.etName.text.toString(),
            binding.etDescription.text.toString()
        )
    }

    override fun showTimePicker(openParams: TimePickerOpenParams) {
        DialogUtils.showSingle(
            childFragmentManager,
            TimePickerDialogFragment.newInstance(openParams)
        )
    }

    override fun showDatePicker(openParams: DatePickerOpenParams) {
        DialogUtils.showSingle(
            childFragmentManager,
            DatePickerDialogFragment.newInstance(openParams)
        )
    }

    override fun onDateClick() {
        presenter.onDateClick()
    }

    override fun onTimeClick() {
        presenter.onTimeClick()
    }

    override fun hideKeyboard() {
        activity?.hideKeyboard()
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    override fun onDateTimeChanged(dateTime: DateTime) {
        presenter.onDateTimeChanged(dateTime)
        viewModel.setDate(dateTime)
    }

    companion object {
        fun newInstance(): AddEventFragment = AddEventFragment()
    }
}