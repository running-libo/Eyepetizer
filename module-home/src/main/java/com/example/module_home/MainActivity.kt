package com.example.module_home

import androidx.lifecycle.Observer
import com.example.base.network.base.BaseMvvmActivity
import com.example.module_home.databinding.ActivityMainBinding

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