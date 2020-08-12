package com.example.playactivity.module

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.base.network.base.viewmodel.BaseViewModel
import com.example.network.interceptor.service.ApiCallBack
import com.example.playactivity.net.IPlayService
import com.example.playactivity.net.PlayDetailResponse
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by apple
 * create on 2020/8/11
 * description
 */
class PlayDetailViewModel(application: Application) : BaseViewModel(application) {
    var detailData = MutableLiveData<PlayDetailResponse>()

    fun getPlayDetailData(videoId: Int) {
        IPlayService.instance.getPlayDetailData(videoId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object: ApiCallBack<PlayDetailResponse>() {
                    override fun onSuccess(m: PlayDetailResponse) {
                        detailData.value = m
                    }

                    override fun onFail(msg: String) {
                        baseLiveData.loadFail.value = 1
                    }

                })
    }

}