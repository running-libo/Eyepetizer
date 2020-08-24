package com.example.module_community

import android.app.Application
import com.example.base.network.base.viewmodel.BasePageViewModel

/**
 * create by apple
 * create on 2020/8/24
 * description
 */
class RecommendHeaderViewModel(application: Application) : BasePageViewModel<String>(application) {

    override fun requestData(page: Int) {
        items.add("")
        items.add("")
    }

    override fun getItemLayoutId(): Int = R.layout.item_recommend_horiscroll
}