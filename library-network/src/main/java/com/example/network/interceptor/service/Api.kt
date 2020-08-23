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

        /**
         * 首页-发现
         */
        const val FIND = "v7/index/tab/discovery"

        /**
         * 首页-日报
         */
        const val DAILY = "v5/index/tab/feed"

        /**
         * 首页-推荐
         */
        const val RECOMMEND = "v5/index/tab/allRec"

        /**
         * 视频播放详情
         */
        const val PLAY_DETAIL = "v2/video/{id}"

        /**
         * 相关视频列表
         */
        const val RELATE_VIDEO = "v4/video/related"

        /**
         * 评论列表
         */
        const val COMMENT_LIST = "v2/replies/video"

        /**
         * 推送
         */
        const val PUSH = "v3/messages"
    }
}