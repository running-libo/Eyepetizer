package com.example.base.network.route


/**
 * create by libo
 * create on 2020/8/7
 * description 路由路径
 */
object RoutePath {

    /**
     * 首页模块
     */
    object Home {
        private const val MAIN = "/home"

        const val HOME_ACTIVITY = "${MAIN}/homeActivity"
    }

    /**
     * 社区模块
     */
    object Community {
        private const val MAIN = "/communication"

        const val COMMUNICATION_FRAGMENT = "${MAIN}/communication"
    }

    /**
     * 通知模块
     */
    object Notification {
        private const val MAIN = "/notification"

        const val NOTIFICATION_FRAGMENT = "${MAIN}/notificationFragment"
    }

    /**
     * 我的模块
     */
    object Mine {
        private const val MAIN = "/mine"

        const val MINE_FRAGMENT = "${MAIN}/mineFragment"
    }

    /**
     * 登录模块
     */
    object Login {
        private const val MAIN = "/login"

        const val LOGIN_ACTIVITY = "${MAIN}/loginActivity"
    }


}