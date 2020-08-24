package com.example.module_community

import android.app.Application
import androidx.recyclerview.widget.GridLayoutManager
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.base.network.bean.CommomItemResponse
import com.example.base.network.bean.CommonItemBean
import com.example.base.network.config.ItemTypeConfig.ITEM_TYPE_COLLECTION
import com.example.base.network.config.ItemTypeConfig.ITEM_TYPE_FOLLOWCARD_UPPER
import com.example.module_community.net.ICommunityService
import com.example.network.interceptor.service.ApiCallBack
import me.tatarka.bindingcollectionadapter2.ItemBinding
import me.tatarka.bindingcollectionadapter2.OnItemBind
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by apple
 * create on 2020/8/23
 * description
 */
class RecommendViewModel(application: Application) : BasePageViewModel<CommonItemBean>(application) {
    var layoutManager = GridLayoutManager(application, 2)

    init {
        refresh()

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position <=1) 2 else 1
            }
        }
    }

    val onItemBind: OnItemBind<CommonItemBean> = OnItemBind { itemBinding, position, item ->
        itemBinding.set(BR.item, getItemType(item)).bindExtra(BR.viewModel, this)
    }

    fun getItemType(item: CommonItemBean): Int {
        when(item.data.dataType) {
            ITEM_TYPE_COLLECTION ->
                return R.layout.item_recommend_header
            ITEM_TYPE_FOLLOWCARD_UPPER ->
                return R.layout.item_recommend
        }
        return R.layout.item_empty
    }

    var multiItemBinding = ItemBinding.of(onItemBind)

    override fun requestData(page: Int) {

        ICommunityService.instance.getRecommendData()
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

    fun getWidthHeightArray(item: CommonItemBean): Array<Int> {
        return arrayOf(item.data.content.data.width, item.data.content.data.height)
    }
}