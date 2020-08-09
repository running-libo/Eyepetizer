package com.example.module_home.module.home

import android.app.Application
import com.example.base.network.base.viewmodel.BaseItemViewModel
import com.example.module_home.R
import com.example.module_home.net.DataResponse
import com.example.module_home.net.IHomeService
import com.example.network.interceptor.service.ApiCallBack
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by apple
 * create on 2020/8/9
 * description
 */
class DailyViewModel(application: Application) : BaseItemViewModel<DataResponse.ItemListBean>(application) {

    override fun getItemLayoutId(): Int = R.layout.itemview

    init {
        refresh()
    }

    override fun requestData() {
        IHomeService.invoke().getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : ApiCallBack<DataResponse>() {
                    override fun onSuccess(dataResponse: DataResponse) {

//                        dataResponse.itemList?.let {
//                            items.addAll(it.)
//                        }

                        dataResponse.itemList?.let { items.addAll(it) }
                        baseLiveData.loadSuccess.postValue(1)
                    }
                })
    }
}