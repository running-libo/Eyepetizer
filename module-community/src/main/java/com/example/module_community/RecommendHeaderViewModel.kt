package com.example.module_community

import android.app.Application
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.base.network.bean.ItemListItem

/**
 * create by apple
 * create on 2020/8/24
 * description
 */
class RecommendHeaderViewModel(application: Application) : BasePageViewModel<ItemListItem>(application) {

    fun setDatas(itemList : ArrayList<ItemListItem>) {
        items.addAll(itemList)
    }

    override fun getItemLayoutId(): Int = R.layout.item_recommend_horiscroll
}