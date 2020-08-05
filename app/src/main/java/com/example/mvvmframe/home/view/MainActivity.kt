package com.example.mvvmframe.home.view

import androidx.lifecycle.Observer
import com.example.base.network.base.BaseMvvmActivity
import com.example.mvvmframe.BR
import com.example.mvvmframe.R
import com.example.mvvmframe.databinding.ActivityMainBinding
import com.example.mvvmframe.home.view.viewmodel.HomeViewModel

class MainActivity : BaseMvvmActivity<ActivityMainBinding, HomeViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        viewModel!!.loadData()
        viewModel!!.loadSuccess.observe(this, Observer { })
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


}