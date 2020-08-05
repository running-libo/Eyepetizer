package com.example.base.network.net

import com.example.base.network.utils.LogUtils
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * create by libo
 * create on 2018/11/13
 * description Okhttp返回数据日志拦截器
 */
class LoggingInterceptor : Interceptor {
    private val byteCount = 1024 * 1024

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        //chain里面包含了request和response，按需获取
        val request = chain.request()
        val response = chain.proceed(request)
        LogUtils.d(String.format("发送请求  %s", request.url()))
        val responseBody = response.peekBody(byteCount.toLong())
        LogUtils.d(String.format("接收响应  %s", responseBody.string()))
        return response
    }
}