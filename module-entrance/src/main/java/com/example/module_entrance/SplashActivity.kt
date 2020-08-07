package com.example.module_entrance

import android.os.Handler
import com.alibaba.android.arouter.launcher.ARouter
import com.example.base.network.base.activity.BaseMvvmActivity
import com.example.base.network.route.RoutePath
import com.example.module_entrance.databinding.ActivitySplashBinding

/**
 * create by libo
 * create on 2020/08/07
 * description  欢迎页面
 */
class SplashActivity : BaseMvvmActivity<ActivitySplashBinding, SplashViewModel>() {

    init {
        fullScreen()
    }

    override fun init() {
        var handler = Handler()

        handler.postDelayed(Runnable {
            ARouter.getInstance().build(RoutePath.Home.HOME_ACTIVITY).navigation()
            finish()
        }, 2000)
    }
}