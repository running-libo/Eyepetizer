package com.example.mvvmframe.home.view.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.example.base.network.base.BaseViewModel
import com.example.base.network.bean.DataResponse
import com.example.base.network.bean.DataResponse.ItemListBean
import com.example.base.network.net.ApiCallBack
import com.example.base.network.net.ApiManager
import com.example.mvvmframe.BR
import com.example.mvvmframe.R
import me.tatarka.bindingcollectionadapter2.ItemBinding
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by libo
 * create on 2020/8/4
 * description
 */
class HomeViewModel(application: Application) : BaseViewModel(application) {
    @JvmField
    var itemBinding = ItemBinding.of<ItemListBean>(BR.item, R.layout.itemview)
    @JvmField
    var items: ObservableList<ItemListBean> = ObservableArrayList()

    fun loadData() {
        ApiManager.mApiService.getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : ApiCallBack<DataResponse>() {
                    override fun onSuccess(dataResponse: DataResponse) {
                        dataResponse.itemList?.let { items.addAll(it) }
                        loadSuccess.postValue(true)
                    }
                })
    }
}