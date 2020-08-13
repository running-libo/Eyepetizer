package com.example.playactivity.module

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.base.network.bean.DailyResponse
import com.example.base.network.config.ItemTypeConfig
import com.example.base.network.route.RoutePath
import com.example.base.network.utils.OnItemClickListener
import com.example.network.interceptor.service.ApiCallBack
import com.example.playactivity.BR
import com.example.playactivity.R
import com.example.playactivity.net.CommentResponse
import com.example.playactivity.net.IPlayService
import com.example.playactivity.net.RelateVideoResponse
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.OnItemBind
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by apple
 * create on 2020/8/12
 * description
 */
class CommentViewModel(application: Application) : BasePageViewModel<CommentResponse.CommentData>(application) {

    val onItemBind: OnItemBind<CommentResponse.CommentData> = OnItemBind { itemBinding, position, item ->
        itemBinding.set(BR.item, getItemType(item))
                .bindExtra(BR.viewModel, this)
    }

    fun getItemType(item: CommentResponse.CommentData): Int {
        when(item.type) {
            ItemTypeConfig.ITEM_TYPE_COMMENT_TITLE ->
                return R.layout.item_comment_title
            ItemTypeConfig.ITEM_TYPE_COMMENT ->
                return R.layout.item_comment
        }

        return R.layout.item_comment_title
    }

    var multiItemBinding = ItemBinding.of(onItemBind)

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