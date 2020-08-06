package com.example.base.network.utils

import android.util.Log

/**
 * create by libo
 * create on 2018/11/13
 * description  日志打印工具类
 */
object LogUtils {
    var isOpenLog = true
    const val TAG = "debugTag"
    fun isOpenLog(isDebug: Boolean) {
        isOpenLog = isDebug
    }

    fun d(content: String?) {
        if (!isOpenLog) return
        Log.d(TAG, content)
    }

    fun d(content: String?, tr: Throwable?) {
        if (!isOpenLog) return
        Log.d(TAG, content, tr)
    }

    fun e(content: String?) {
        if (!isOpenLog) return
        Log.e(TAG, content)
    }

    fun e(content: String?, tr: Throwable?) {
        if (!isOpenLog) return
        Log.e(TAG, content, tr)
    }

    fun i(content: String?) {
        if (!isOpenLog) return
        Log.i(TAG, content)
    }

    fun i(content: String?, tr: Throwable?) {
        if (!isOpenLog) return
        Log.i(TAG, content, tr)
    }

    fun v(content: String?) {
        if (!isOpenLog) return
        Log.v(TAG, content)
    }

    fun v(content: String?, tr: Throwable?) {
        if (!isOpenLog) return
        Log.v(TAG, content, tr)
    }

    fun w(content: String?) {
        if (!isOpenLog) return
        Log.w(TAG, content)
    }

    fun w(content: String?, tr: Throwable?) {
        if (!isOpenLog) return
        Log.w(TAG, content, tr)
    }

    fun w(tr: Throwable?) {
        if (!isOpenLog) return
        Log.w(TAG, tr)
    }

    fun wtf(content: String?) {
        if (!isOpenLog) return
        Log.wtf(TAG, content)
    }

    fun wtf(content: String?, tr: Throwable?) {
        if (!isOpenLog) return
        Log.wtf(TAG, content, tr)
    }

    fun wtf(tr: Throwable?) {
        if (!isOpenLog) return
        Log.wtf(TAG, tr)
    }
}