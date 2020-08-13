package com.example.module_home.viewmodel

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.base.network.config.ItemTypeConfig
import com.example.base.network.route.RoutePath
import com.example.base.network.utils.OnItemClickListener
import com.example.module_home.BR
import com.example.module_home.R
import com.example.base.network.bean.CommomItemResponse
import com.example.base.network.bean.CommonItemBean
import com.example.module_home.net.IHomeService
import com.example.network.interceptor.service.ApiCallBack
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.OnItemBind
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by apple
 * create on 2020/8/9
 * description
 */
class DailyViewModel(application: Application) : BasePageViewModel<CommonItemBean>(application) {

    val onItemBind: OnItemBind<CommonItemBean> = OnItemBind { itemBinding, position, item ->
        itemBinding.set(BR.item, getItemType(item))
                .bindExtra(BR.itemClick, onItemClick())
    }

    var multiItemBinding = ItemBinding.of(onItemBind)

    init {
        refresh()
    }

    /**
     * 根据实体类类型设置当前item布局类型
     */
    fun getItemType(item: CommonItemBean): Int {

        when(item.type) {
            ItemTypeConfig.ITEM_TYPE_TEXTCARD ->
                return R.layout.item_title
            ItemTypeConfig.ITEM_TYPE_FOLLOWCARD ->
                return R.layout.item_big_card
            ItemTypeConfig.ITEM_TYPE_PICTURE_FOLLOWCARD ->
                return R.layout.item_big_card
            ItemTypeConfig.ITEM_TYPE_AUTOPLAY_FOLLOWCARD ->
                return R.layout.item_big_card
        }

        return return R.layout.item_empty
    }

    override fun requestData(page: Int) {
        IHomeService.instance.getDailyData(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object: ApiCallBack<CommomItemResponse>() {
                    override fun onSuccess(response: CommomItemResponse) {
                        handleItemData(page, response.itemList)
                    }

                    override fun onFail(msg: String) {
                        handleFail()
                    }

                })
    }

    fun onItemClick(): OnItemClickListener<CommonItemBean> {
        return object: OnItemClickListener<CommonItemBean> {
            override fun onItemClick(bean: CommonItemBean) {

                if (bean.data.content != null && bean.data.content.data.playUrl != null) {
                    ARouter.getInstance().build(RoutePath.Play.PLAY_DETAIL_ACTIVITY)
                            .withInt("videoId", bean.data.content.data.id)
                            .navigation()
                }
            }

        }
    }

}