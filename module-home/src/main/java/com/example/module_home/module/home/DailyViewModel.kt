package com.example.module_home.module.home

import android.app.Application
import android.text.TextUtils
import com.alibaba.android.arouter.launcher.ARouter
import com.example.base.network.base.viewmodel.BasePageViewModel
import com.example.base.network.route.RoutePath
import com.example.base.network.utils.OnItemClickListener
import com.example.base.network.utils.ToastUtil
import com.example.module_home.BR
import com.example.module_home.R
import com.example.module_home.net.DailyResponse
import com.example.module_home.net.IHomeService
import com.example.network.interceptor.service.ApiCallBack
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * create by apple
 * create on 2020/8/9
 * description
 */
class DailyViewModel(application: Application) : BasePageViewModel<DailyResponse.DailyItemBean>(application) {

    override fun getItemLayoutId(): Int = R.layout.item_daily

    init {
        itemBinding.bindExtra(BR.itemClick, onItemClick())
        refresh()
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