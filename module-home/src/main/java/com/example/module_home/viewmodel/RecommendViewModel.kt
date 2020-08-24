package com.example.module_home.viewmodel

import android.app.Application
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.base.network.bean.CommomItemResponse
import com.example.base.network.bean.CommonItemBean
import com.example.base.network.config.ItemTypeConfig
import com.example.module_home.BR
import com.example.module_home.R
import com.example.module_home.net.IHomeService
import com.example.network.interceptor.service.ApiCallBack
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.OnItemBind
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by apple
 * create on 2020/8/13
 * description
 */
class RecommendViewModel(application: Application) : BasePageViewModel<CommonItemBean>(application) {

    val onItemBind: OnItemBind<CommonItemBean> = OnItemBind { itemBinding, position, item ->
        itemBinding.set(BR.item, getItemType(item))
    }

    var multiItemBinding = ItemBinding.of(onItemBind)

    init {
        refresh()
    }

    /**
     * 根据实体类类型设置当前item布局类型
     */
    fun getItemType(item: CommonItemBean): Int {

        when(item.data.dataType) {
            ItemTypeConfig.ITEM_TYPE_TEXTCARD ->
                return R.layout.item_title
            ItemTypeConfig.ITEM_TYPE_FOLLOWCARD_UPPER ->
                return R.layout.item_big_card
            ItemTypeConfig.ITEM_TYPE_PICTURE_FOLLOWCARD ->
                return R.layout.item_big_card
            ItemTypeConfig.ITEM_TYPE_AUTOPLAY_FOLLOWCARD ->
                return R.layout.item_big_card
            ItemTypeConfig.ITEM_TYPE_SQUARECARD ->
                return R.layout.item_header
            ItemTypeConfig.ITEM_TYPE_VIDEOAD ->
                return R.layout.item_videoad
            ItemTypeConfig.ITEM_TYPE_BANNER ->
                return R.layout.item_only_pic
            ItemTypeConfig.ITEM_TYPE_VIDEOBEANFORCLIENT ->
                return R.layout.item_small_card
        }

        return return R.layout.item_empty
    }

    override fun requestData(page: Int) {
        IHomeService.instance.getRecommend(page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object: ApiCallBack<CommomItemResponse>() {
                    override fun onSuccess(m: CommomItemResponse) {
                        handleItemData(page, m.itemList)
                    }

                    override fun onFail(msg: String) {
                        handleFail()
                    }

                })
    }
}