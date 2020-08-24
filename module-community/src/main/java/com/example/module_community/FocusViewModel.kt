package com.example.module_community

import android.app.Application
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.base.network.bean.CommomItemResponse
import com.example.base.network.bean.CommonItemBean
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
class FocusViewModel(application: Application) : BasePageViewModel<CommonItemBean>(application) {

    init {
        refresh()
    }

    val onItemBind: OnItemBind<CommonItemBean> = OnItemBind { itemBinding, position, item ->
        itemBinding.set(BR.item, getItemType(position))
    }

    fun getItemType(position: Int): Int {
        if (position == 0) {
            return R.layout.include_focus_header
        } else {
            return R.layout.item_focus
        }
    }

    var multiItemBinding = ItemBinding.of(onItemBind)

    override fun requestData(page: Int) {

        ICommunityService.instance.getFocusList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object: ApiCallBack<CommomItemResponse>() {
                    override fun onSuccess(m: CommomItemResponse) {
                        m.itemList.add(m.itemList.get(0))
                        handleItemData(page, m.itemList)
                    }

                    override fun onFail(msg: String) {
                        handleFail()
                    }

                })
    }

}