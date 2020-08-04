package com.example.mvvmframe.network;

import static com.example.mvvmframe.config.AppConfig.isDebug;

/**
 * create by libo
 * create on 2020/8/3
 * description
 */
public interface Api {

    /** *******************************************  IP配置  ******************************************** */

    /** 正式服务器地址 */
    String SERVER_ADDRESS_RELEASE = "http://baobab.kaiyanapp.com/api/";

    /** 测试服务器地址 */
    String SERVER_ADDRESS_DEBUG = "http://baobab.kaiyanapp.com/api/";

    /** 服务器域名 */
    String SERVER_ADDRESS = isDebug ? SERVER_ADDRESS_DEBUG : SERVER_ADDRESS_RELEASE;

    String URL = "v7/topic/list";
}
