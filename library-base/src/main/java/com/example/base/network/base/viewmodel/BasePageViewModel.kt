package com.example.base.network.base.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.example.base.BR
import me.tatarka.bindingcollectionadapter2.ItemBinding

/**
 * create by libo
 * create on 2020/8/4
 * description 列表页面viewModel基类
 */
open abstract class BasePageViewModel<T>(application: Application) : BaseViewModel(application) {
    val items = ObservableArrayList<T>()

    val itemBinding by lazy {
        ItemBinding.of<T>(BR.item, getItemLayoutId()).bindExtra(BR.viewModel, this)
    }

    /**
     * 获取item的布局ID
     */
    abstract fun getItemLayoutId(): Int

    abstract fun requestData(page: Int)

    fun getStartPageNum(): Int = 0

    fun refresh() {
        requestData(getStartPageNum())
    }

    fun loadMore() {
        requestData(0)
    }

    fun handleItemData(page: Int, datas: List<T>) {
        if (page == getStartPageNum()) {
            items.clear()
            baseLiveData.refresh.postValue(1)  //通知刷新完成
        }

        items.addAll(datas)

        if (items.size == 0) {
            // TODO: 2020/8/11   空数据，显示空布局
        }
    }

}