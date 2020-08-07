package com.example.module_home

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.example.base.network.base.viewmodel.BaseViewModel
import com.example.base.network.bean.DataResponse
import com.example.base.network.bean.DataResponse.ItemListBean
import com.example.network.interceptor.service.ApiCallBack
import com.example.network.interceptor.service.ApiManager
import me.tatarka.bindingcollectionadapter2.ItemBinding
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by libo
 * create on 2020/8/4
 * description
 */
class HomeViewModel(application: Application) : BaseViewModel(application) {
    var itemBinding = ItemBinding.of<ItemListBean>(BR.item, R.layout.itemview)
    var items: ObservableList<ItemListBean> = ObservableArrayList()

    init {
        loadData()
    }

    fun loadData() {
        ApiManager.mApiService.getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : ApiCallBack<DataResponse>() {
                    override fun onSuccess(dataResponse: DataResponse) {

                        dataResponse.itemList?.let {
                            items.addAll(it)
                        }
                        baseLiveData.loadSuccess.postValue(1)
                    }
                })
    }
}