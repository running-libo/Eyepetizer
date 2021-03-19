package com.example.network.interceptor.service

import com.example.base.network.config.AppConfig
import com.example.base.network.config.DirConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * create by libo
 * create on 2018/11/13
 * description 单例的Retrofit和Okhttp管理类
 */
object ApiManager {

    private val TIMEOUT = 10

    private val mOkHttpClient: OkHttpClient by lazy {
        val builder = OkHttpClient.Builder()
                .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS) //连接超时设置
                .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS) //写入缓存超时10s
                .writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS) //读取缓存超时10s
                .retryOnConnectionFailure(true) //失败重连
                .addInterceptor(com.example.network.interceptor.interceptor.HeaderInterceptor()) //添加header
                .addInterceptor(com.example.network.interceptor.interceptor.NetCacheInterceptor()) //添加网络缓存
        addLogIntercepter(builder) //日志拦截器
        setCacheFile(builder) //网络缓存
        builder.build()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(Api.getBaseUrl())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build()
    }

    /**
     * 设置缓存文件路径
     */
    private fun setCacheFile(builder: OkHttpClient.Builder) {
        //设置缓存文件
        val cacheFile = File(DirConfig.HTTP_CACHE)
        //缓存大小为10M
        val cacheSize = 10 * 1024 * 1024
        val cache = Cache(cacheFile, cacheSize.toLong())
        builder.cache(cache)
    }

    /**
     * 调试模式下加入日志拦截器
     * @param builder
     */
    private fun addLogIntercepter(builder: OkHttpClient.Builder) {
        if (AppConfig.isDebug) {
            builder.addInterceptor(com.example.network.interceptor.interceptor.LoggingInterceptor())
        }
    }

}