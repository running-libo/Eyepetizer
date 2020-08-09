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
open abstract class BaseItemViewModel<T>(application: Application) : BaseViewModel(application) {
    val items = ObservableArrayList<T>()

    val itemBinding by lazy {
        ItemBinding.of<T>(BR.item, getItemLayoutId()).bindExtra(BR.viewModel, this)
    }

    /**
     * 获取item的布局ID
     */
    abstract fun getItemLayoutId(): Int

    abstract fun requestData()

    fun refresh() {
        requestData()
    }

    fun loadMore() {
        requestData()
    }

}