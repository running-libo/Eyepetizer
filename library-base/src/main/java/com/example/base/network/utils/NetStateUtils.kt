package com.example.base.network.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * create by libo
 * create on 2020/8/7
 * description
 */
class NetStateUtils {
    /**
     * 获取当前网络类型
     *
     * @param context
     * @return
     */
    fun getNetworkState(context: Context): NetStateEnum {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (manager.activeNetworkInfo == null) {
            return NetStateEnum.NONE
        }
        val netType = manager.activeNetworkInfo.type
        return when (netType) {
            ConnectivityManager.TYPE_WIFI -> NetStateEnum.WIFI
            ConnectivityManager.TYPE_MOBILE -> NetStateEnum.MOBILE
            else -> NetStateEnum.NONE
        }
    }

    /**
     * 检测是否有网络
     *
     * @param context
     * @return
     */
    fun isHasNet(context: Context): Boolean {
        return if (getNetworkState(context) == NetStateEnum.NONE) false else true
    }

    enum class NetStateEnum {
        NONE, WIFI, MOBILE
    }
}