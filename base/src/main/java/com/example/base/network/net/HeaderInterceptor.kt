package com.example.base.network.net

import com.example.base.network.bean.UserInfoCache
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * create by libo
 * create on 2018/11/13
 * description 统一添加header的拦截器
 */
class HeaderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("token", UserInfoCache.TOKEN)
        return chain.proceed(builder.build())
    }
}