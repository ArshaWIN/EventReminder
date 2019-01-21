package com.ilya.mihailenko.eventreminder.presentation.ui.main

import android.databinding.DataBindingUtil
import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.ilya.mihailenko.eventreminder.R
import com.ilya.mihailenko.eventreminder.databinding.ActivityMainBinding
import com.ilya.mihailenko.eventreminder.presentation.ui.mvp.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(), MainView {


    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.test.text = "test"
    }

    override fun inflateBinding(): ActivityMainBinding =
        DataBindingUtil.setContentView(this, R.layout.activity_main)
}
