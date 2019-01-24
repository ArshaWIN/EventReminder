package com.ilya.mihailenko.eventreminder.presentation.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.ilya.mihailenko.eventreminder.R
import com.ilya.mihailenko.eventreminder.databinding.ActivityMainBinding
import com.ilya.mihailenko.eventreminder.navigation.MainActivityNavigator
import com.ilya.mihailenko.eventreminder.presentation.mvp.BaseActivity
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(), MainView {

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter = presenter

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var navigator: MainActivityNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.go()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun inflateBinding(): ActivityMainBinding =
        DataBindingUtil.setContentView(this, R.layout.activity_main)
}
