package com.example.base.network.utils;

import android.util.Log;

/**
 * create by libo
 * create on 2018/11/13
 * description  日志打印工具类
 */
public class LogUtils {
    public static boolean isOpenLog = true;
    public static final String TAG = "debugTag";

    public static void isOpenLog(boolean isDebug) {
        isOpenLog = isDebug;
    }

    public static void d(String content) {
        if (!isOpenLog) return;

        Log.d(TAG, content);
    }

    public static void d(String content, Throwable tr) {
        if (!isOpenLog) return;

        Log.d(TAG, content, tr);
    }

    public static void e(String content) {
        if (!isOpenLog) return;

        Log.e(TAG, content);
    }

    public static void e(String content, Throwable tr) {
        if (!isOpenLog) return;

        Log.e(TAG, content, tr);
    }

    public static void i(String content) {
        if (!isOpenLog) return;

        Log.i(TAG, content);
    }

    public static void i(String content, Throwable tr) {
        if (!isOpenLog) return;

        Log.i(TAG, content, tr);
    }

    public static void v(String content) {
        if (!isOpenLog) return;

        Log.v(TAG, content);
    }

    public static void v(String content, Throwable tr) {
        if (!isOpenLog) return;

        Log.v(TAG, content, tr);
    }

    public static void w(String content) {
        if (!isOpenLog) return;

        Log.w(TAG, content);
    }

    public static void w(String content, Throwable tr) {
        if (!isOpenLog) return;

        Log.w(TAG, content, tr);
    }

    public static void w(Throwable tr) {
        if (!isOpenLog) return;

        Log.w(TAG, tr);
    }

    public static void wtf(String content) {
        if (!isOpenLog) return;

        Log.wtf(TAG, content);
    }

    public static void wtf(String content, Throwable tr) {
        if (!isOpenLog) return;

        Log.wtf(TAG, content, tr);
    }

    public static void wtf(Throwable tr) {
        if (!isOpenLog) return;

        Log.wtf(TAG, tr);
    }
}