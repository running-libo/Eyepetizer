package com.example.base.network.application

/**
 * create by libo
 * create on 2018/11/15
 * description Application生命周期回调
 */
interface ApplicationDelegate {

    fun onCreate()

    fun onTerminate()

    fun onLowMemory()

    fun onTrimMemory(level: Int)
}