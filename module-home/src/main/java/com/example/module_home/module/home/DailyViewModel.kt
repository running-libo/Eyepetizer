package com.example.module_home.module.home

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.base.network.config.ItemTypeConfig
import com.example.base.network.route.RoutePath
import com.example.base.network.utils.OnItemClickListener
import com.example.module_home.BR
import com.example.module_home.R
import com.example.base.network.bean.DailyResponse
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
class DailyViewModel(application: Application) : BasePageViewModel<DailyResponse.DailyItemBean>(application) {

    val onItemBind: OnItemBind<DailyResponse.DailyItemBean> = OnItemBind { itemBinding, position, item ->
        itemBinding.set(BR.item, getItemType(item))
                .bindExtra(BR.viewModel, this)
                .bindExtra(BR.itemClick, onItemClick())
    }

    var multiItemBinding = ItemBinding.of(onItemBind)

    init {
        refresh()
    }

    /**
     * 根据实体类类型设置当前item布局类型
     */
    fun getItemType(item: DailyResponse.DailyItemBean): Int {

        when(item.type) {
            ItemTypeConfig.ITEM_TYPE_TEXTCARD ->
                return R.layout.item_title
            ItemTypeConfig.ITEM_TYPE_FOLLOWCARD ->
                return R.layout.item_daily
            ItemTypeConfig.ITEM_TYPE_PICTURE_FOLLOWCARD ->
                return R.layout.item_daily
            ItemTypeConfig.ITEM_TYPE_AUTOPLAY_FOLLOWCARD ->
                return R.layout.item_daily
        }

        return return R.layout.item_title
    }

    override fun requestData(page: Int) {
        IHomeService.instance.getDailyData(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object: ApiCallBack<DailyResponse>() {
                    override fun onSuccess(response: DailyResponse) {
                        handleItemData(page, response.itemList)
                    }

                    override fun onFail(msg: String) {
                        handleFail()
                    }

                })
    }

    fun onItemClick(): OnItemClickListener<DailyResponse.DailyItemBean> {
        return object: OnItemClickListener<DailyResponse.DailyItemBean> {
            override fun onItemClick(bean: DailyResponse.DailyItemBean) {

                if (bean.data.content != null && bean.data.content.data.playUrl != null) {
                    ARouter.getInstance().build(RoutePath.Play.PLAY_DETAIL_ACTIVITY)
                            .withInt("videoId", bean.data.content.data.id)
                            .navigation()
                }
            }

        }
    }

}