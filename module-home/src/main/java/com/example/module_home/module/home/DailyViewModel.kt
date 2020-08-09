package com.example.module_home.module.home

import android.app.Application
import com.example.base.network.base.viewmodel.BaseItemViewModel
import com.example.module_home.R

/**
 * create by apple
 * create on 2020/8/9
 * description
 */
class DailyViewModel(application: Application) : BaseItemViewModel<String>(application) {

    override fun getItemLayoutId(): Int = R.layout.itemview

    init {
        refresh()
    }

    override fun requestData() {
        for (i in 0..10) {
            items.add("")
        }
    }
}