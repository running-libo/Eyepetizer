package com.example.module_community

import android.app.Application
import com.example.base.network.base.viewmodel.BasePageViewModel

/**
 * create by apple
 * create on 2020/8/23
 * description
 */
class FocusViewModel(application: Application) : BasePageViewModel<String>(application) {

    init {
        refresh()
    }

    override fun requestData(page: Int) {
        for (i in 0..9) {
            items.add("")
        }
    }

    override fun getItemLayoutId(): Int = R.layout.item_focus
}