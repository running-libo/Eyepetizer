package com.example.network.interceptor.service

import android.widget.Toast
import com.example.base.network.utils.ToastUtil
import com.example.network.BuildConfig

/**
 * create by libo
 * create on 2020/8/3
 * description
 */
interface Api {

    companion object {
        /** *******************************************  IP配置  ********************************************  */

        /** 开发服务器地址  */
        private const val SERVER_ADDRESS_DEV = "http://baobab.kaiyanapp.com/api/"

        /** 测试服务器地址  */
        private const val SERVER_ADDRESS_BETA = "http://baobab.kaiyanapp.com/api/"

        /** 正式服务器地址  */
        private const val SERVER_ADDRESS_RELEASE = "http://baobab.kaiyanapp.com/api/"

        /**
         * 获取服务器域名
         */
        fun getBaseUrl(): String? {
            return when (BuildConfig.CUR_ENV) {
                BuildConfig.IS_DEV -> {
                    ToastUtil.show("开发环境")
                    SERVER_ADDRESS_DEV
                }
                BuildConfig.IS_BETA -> {
                    ToastUtil.show("测试环境")
                    SERVER_ADDRESS_BETA
                }
                BuildConfig.IS_RELEASE -> {
                    ToastUtil.show("正式环境")
                    SERVER_ADDRESS_RELEASE
                }
                else -> ""
            }
        }

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
        const val HOME_RECOMMEND = "v5/index/tab/allRec"

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

        /**
         * 社区-关注
         */
        const val FOCUS = "v6/community/tab/follow"

        /**
         * 社区-推荐
         */
        const val COMMUNITY_RECOMMEND = "v7/community/tab/rec"
    }
}