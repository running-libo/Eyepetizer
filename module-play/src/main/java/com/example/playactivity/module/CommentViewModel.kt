package com.example.playactivity.module

import android.app.Application
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.network.interceptor.service.ApiCallBack
import com.example.playactivity.R
import com.example.playactivity.net.CommentResponse
import com.example.playactivity.net.IPlayService
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by apple
 * create on 2020/8/12
 * description
 */
class CommentViewModel(application: Application) : BasePageViewModel<CommentResponse.CommentData>(application) {

    override fun getItemLayoutId(): Int = R.layout.item_comment

    fun getComments(videoId: Int) {
        IPlayService.instance.getCommentList(videoId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object: ApiCallBack<CommentResponse>() {
                    override fun onSuccess(m: CommentResponse) {
                        handleItemData(0, m.itemList)
                    }

                    override fun onFail(msg: String) {
                        handleFail()
                    }

                })
    }

}