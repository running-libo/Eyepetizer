package com.example.module_home.module.home

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import com.example.base.network.base.viewmodel.BaseItemViewModel
import com.example.module_home.BR
import com.example.module_home.R
import com.example.module_home.net.DataResponse
import com.example.module_home.net.DataResponse.ItemListBean
import com.example.module_home.net.IHomeService
import com.example.network.interceptor.service.ApiCallBack
import me.tatarka.bindingcollectionadapter2.ItemBinding
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by libo
 * create on 2020/8/4
 * description
 */
class HomeViewModel(application: Application) : BaseItemViewModel<String>(application) {

    fun loadData() {
        IHomeService.invoke().getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : ApiCallBack<DataResponse>() {
                    override fun onSuccess(dataResponse: DataResponse) {

//                        dataResponse.itemList?.let {
////                            items.addAll(it)
//                        }
//                        baseLiveData.loadSuccess.postValue(1)
                    }
                })

    }

    override fun getItemLayoutId(): Int = R.layout.itemview

    override fun requestData() {

    }
}