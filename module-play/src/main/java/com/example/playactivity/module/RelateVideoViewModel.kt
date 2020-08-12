package com.example.playactivity.module

import android.app.Application
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.playactivity.R

/**
 * create by apple
 * create on 2020/8/12
 * description
 */
class RelateVideoViewModel(application: Application) : BasePageViewModel<String>(application) {

    override fun requestData(page: Int) {
        for (i in 0..6) {
            items.add("")
        }
    }

    override fun getItemLayoutId(): Int = R.layout.item_relate

    init {
//        itemBinding.bindExtra(BR.itemClick, onItemClick())
        refresh()
    }
}