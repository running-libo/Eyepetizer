package com.example.module_notice

import android.app.Application
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.base.network.bean.PushBean
import com.example.module_notice.net.INoticeService
import com.example.module_notice.response.PushResponse
import com.example.network.interceptor.service.ApiCallBack
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by apple
 * create on 2020/8/23
 * description
 */
class PushViewModel(application: Application) : BasePageViewModel<PushBean>(application) {

    init {
        refresh()
    }

    override fun requestData(page: Int) {

        INoticeService.instance.getPushData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object: ApiCallBack<PushResponse>() {
                    override fun onSuccess(m: PushResponse) {
                        handleItemData(page, m.messageList)
                    }

                    override fun onFail(msg: String) {
                        handleFail()
                    }

                })

    }

    override fun getItemLayoutId(): Int = R.layout.item_notice

}