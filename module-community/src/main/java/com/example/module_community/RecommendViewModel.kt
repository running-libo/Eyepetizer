package com.example.module_community

import android.app.Application
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.base.network.bean.CommomItemResponse
import com.example.base.network.bean.CommonItemBean
import com.example.module_community.net.ICommunityService
import com.example.network.interceptor.service.ApiCallBack
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by apple
 * create on 2020/8/23
 * description
 */
class RecommendViewModel(application: Application) : BasePageViewModel<CommonItemBean>(application) {

    init {
        refresh()
    }

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

    override fun getItemLayoutId(): Int = R.layout.item_recommend

    fun getWidthHeightArray(width: Int, height: Int): Array<Int> {
        return arrayOf(width, height)
    }
}