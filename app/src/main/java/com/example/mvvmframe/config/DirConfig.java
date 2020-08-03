package com.example.mvvmframe.config;

import android.os.Environment;

/**
 * create by libo
 * create on 2018/11/13
 * description 存储路径配置
 */
public class DirConfig {

    /**
     * 请求数据缓存
     */
    public static final String HTTP_CACHE = Environment.getExternalStorageDirectory().getAbsolutePath() + "/httpCache";

}