package com.branjunhoe.cleanarchitecture.ui.main

import com.branjunhoe.cleanarchitecture.BR
import com.branjunhoe.cleanarchitecture.R
import com.branjunhoe.cleanarchitecture.databinding.ActivityMainBinding
import com.branjunhoe.cleanarchitecture.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val mainViewModel: MainViewModel by viewModel { parametersOf(userName)}

    override val layoutResourceId: Int = R.layout.activity_main
    override val bindingVariable: Int = BR.vm
    override val viewModel: MainViewModel get() = mainViewModel

    private val userName = "ehwnsghl2"

    override fun setUp() {
    }


}
