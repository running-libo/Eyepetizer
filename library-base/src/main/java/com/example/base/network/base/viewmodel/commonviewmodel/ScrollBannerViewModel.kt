package com.example.base.network.base.viewmodel.commonviewmodel

import android.app.Application
import com.example.base.R
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.base.network.bean.ItemListItem

/**
 * create by apple
 * create on 2020/8/24
 * description
 */
class ScrollBannerViewModel(application: Application) : BasePageViewModel<ItemListItem>(application) {

    fun setDatas(itemList : ArrayList<ItemListItem>) {
        items.addAll(itemList)
    }

    override fun getItemLayoutId(): Int = R.layout.item_scroll_banner_item
}