package com.example.network.interceptor.service

import com.example.base.network.config.AppConfig

/**
 * create by libo
 * create on 2020/8/3
 * description
 */
interface Api {
    companion object {
        /** *******************************************  IP配置  ********************************************  */
        /** 正式服务器地址  */
        const val SERVER_ADDRESS_RELEASE = "http://baobab.kaiyanapp.com/api/"

        /** 测试服务器地址  */
        const val SERVER_ADDRESS_DEBUG = "http://baobab.kaiyanapp.com/api/"

        /** 服务器域名  */
        val SERVER_ADDRESS = if (AppConfig.isDebug) SERVER_ADDRESS_DEBUG else SERVER_ADDRESS_RELEASE

        const val URL = "v7/topic/list"
    }
}