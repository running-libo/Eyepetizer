package com.example.base.network.net

import com.example.base.network.base.BaseModel
import com.example.base.network.utils.LogUtils
import org.jetbrains.annotations.NotNull
import retrofit2.adapter.rxjava.HttpException
import rx.Subscriber

/**
 * create by libo
 * create on 2018/11/13
 * description 自定义请求数据回调和过滤
 */
abstract class ApiCallBack<M : BaseModel<*>?> : Subscriber<M>() {
    override fun onCompleted() {}
    override fun onError(e: Throwable) {
        e.printStackTrace()
        if (e is HttpException) {
            val code = e.code()

            //Http状态码提示
            if (code >= 400 && code < 500) {
                LogUtils.e("请求错误")
            } else if (code >= 500) {
                LogUtils.e("服务器错误")
            }
        }
    }

    override fun onNext(baseModel: M) {
        onSuccess(baseModel)
    }

    /**
     * onSuccess回调的数据为程序具体需要的业务状态码，具体数据等
     */
    abstract fun onSuccess(@NotNull m: M)
}