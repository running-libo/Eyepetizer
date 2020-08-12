package com.example.playactivity.module

import android.app.Application
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.network.interceptor.service.ApiCallBack
import com.example.playactivity.R
import com.example.playactivity.net.IPlayService
import com.example.playactivity.net.RelateVideoResponse
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by apple
 * create on 2020/8/12
 * description
 */
class RelateVideoViewModel(application: Application) : BasePageViewModel<RelateVideoResponse.RelateVideoItemBean>(application) {

    override fun getItemLayoutId(): Int = R.layout.item_relate

    fun getRelateVideos(videoId: Int) {

        IPlayService.instance.getRelateVideos(videoId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object: ApiCallBack<RelateVideoResponse>() {
                    override fun onSuccess(m: RelateVideoResponse) {

                        handleItemData(0, m.itemList)
                    }

                    override fun onFail(msg: String) {
                        handleFail()
                    }

                })
    }
}