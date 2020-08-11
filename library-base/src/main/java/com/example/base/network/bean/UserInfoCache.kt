package com.example.base.network.bean

import android.text.TextUtils

/**
 * create by libo
 * create on 2018/12/18
 * description 缓存的用户信息
 */
object UserInfoCache {
    var USERID: String? = null
    var TOKEN = ""
    var NIKENAME: String? = null

    /**
     * 当前是否为登录状态
     */
    fun isLogin(): Boolean {
        return !TextUtils.isEmpty(TOKEN)
    }
}