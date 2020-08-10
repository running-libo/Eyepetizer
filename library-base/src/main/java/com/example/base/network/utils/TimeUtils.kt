package com.example.base.network.utils

/**
 * create by apple
 * create on 2020/8/10
 * description 时间转化工具类
 */
object TimeUtils {

    /**
     * 秒转为 00:00 ，单位为秒
     * @param duration
     */
    fun duration2Time(duration: Long): String? {
        val m = duration / 60
        val s = duration % 60
        val builder = StringBuilder()
        builder.append(m / 10).append(m % 10).append(":").append(s / 10).append(s % 10)
        return builder.toString()
    }
}