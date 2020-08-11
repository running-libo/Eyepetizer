package com.example.network.interceptor.interceptor

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.alibaba.android.arouter.launcher.ARouter
import com.example.base.network.bean.UserInfoCache
import com.example.base.network.route.RoutePath

/**
 * create by apple
 * create on 2020/8/11
 * description 登录拦截器
 */
@Interceptor(priority = 3)
class LoginInterceptor : IInterceptor {

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        if (!UserInfoCache.isLogin()) {
            ARouter.getInstance().build(RoutePath.Login.LOGIN_ACTIVITY).navigation()
            callback!!.onInterrupt(null)
        } else {
            callback!!.onContinue(postcard)
        }
    }

    override fun init(context: Context?) {

    }

}