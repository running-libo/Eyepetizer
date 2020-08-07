package com.example.module_home

import androidx.lifecycle.Observer
import com.example.base.network.base.activity.BaseMvvmActivity
import com.example.module_home.databinding.ActivityMainBinding

class MainActivity : BaseMvvmActivity<ActivityMainBinding, HomeViewModel>() {

    override fun init() {
        viewModel.baseLiveData.loadSuccess.observe(this, Observer {

        })
    }

}