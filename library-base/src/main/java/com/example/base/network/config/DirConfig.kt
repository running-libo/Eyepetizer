package com.example.base.network.config

import android.os.Environment

/**
 * create by libo
 * create on 2018/11/13
 * description 存储路径配置
 */
object DirConfig {
    /**
     * 请求数据缓存
     */
    val HTTP_CACHE = Environment.getExternalStorageDirectory().absolutePath + "/httpCache"
}