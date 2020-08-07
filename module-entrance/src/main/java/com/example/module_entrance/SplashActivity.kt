package com.example.module_entrance

import com.example.base.network.base.activity.BaseMvvmActivity
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
}