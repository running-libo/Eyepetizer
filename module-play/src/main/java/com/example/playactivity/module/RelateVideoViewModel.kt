package com.example.playactivity.module

import android.app.Application
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.base.network.config.ItemTypeConfig
import com.example.base.network.utils.OnItemClickListener
import com.example.network.interceptor.service.ApiCallBack
import com.example.playactivity.BR
import com.example.playactivity.R
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
class RelateVideoViewModel(application: Application) : BasePageViewModel<RelateVideoResponse.RelateVideoItemBean>(application) {

    val onItemBind: OnItemBind<RelateVideoResponse.RelateVideoItemBean> = OnItemBind { itemBinding, position, item ->
        itemBinding.set(BR.item, getItemType(item))
                .bindExtra(BR.viewModel, this)
                .bindExtra(BR.itemClick, onItemClick())
    }

    var multiItemBinding = ItemBinding.of(onItemBind)

    fun getItemType(item: RelateVideoResponse.RelateVideoItemBean): Int {
        when(item.type) {
            ItemTypeConfig.ITEM_TYPE_TEXTCARD ->
                return R.layout.item_empty
            ItemTypeConfig.ITEM_TYPE_VIDEO_SAMLLCARD ->
                return R.layout.item_relate
        }

        return return R.layout.item_title
    }

    fun onItemClick(): OnItemClickListener<RelateVideoResponse.RelateVideoItemBean> {
        return object: OnItemClickListener<RelateVideoResponse.RelateVideoItemBean> {
            override fun onItemClick(bean: RelateVideoResponse.RelateVideoItemBean) {

//                if (bean.data.content != null && bean.data.content.data.playUrl != null) {
//                    ARouter.getInstance().build(RoutePath.Play.PLAY_DETAIL_ACTIVITY)
//                            .withInt("videoId", bean.data.content.data.id)
//                            .navigation()
//                }
            }

        }
    }

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