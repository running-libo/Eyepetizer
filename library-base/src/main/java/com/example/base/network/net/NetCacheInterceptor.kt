package com.example.base.network.net

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * create by libo
 * create on 2018/11/13
 * description 网络拦截器进行网络缓存
 */
class NetCacheInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        val onlineCacheTime = 60
        return response.newBuilder()
                .header("Cache-Control", "public, max-age=$onlineCacheTime")
                .removeHeader("Pragma")
                .build()
    }
}