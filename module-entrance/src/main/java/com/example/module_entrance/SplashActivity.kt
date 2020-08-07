package com.example.module_entrance

import android.os.Handler
import com.alibaba.android.arouter.launcher.ARouter
import com.example.base.network.base.activity.BaseMvvmActivity
import com.example.base.network.route.RoutePath
import com.example.base.network.utils.AnimUtils
import com.example.module_entrance.databinding.ActivitySplashBinding
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * create by libo
 * create on 2020/08/07
 * description  欢迎页面
 */
class SplashActivity : BaseMvvmActivity<ActivitySplashBinding, SplashViewModel>() {
    var handler = Handler()
    val animDuration: Long = 2000

    init {
        fullScreen()
    }

    override fun init() {
        countDown()

        scaleAnim()
    }

    /**
     * 进入主页倒计时
     */
    fun countDown() {
        handler.postDelayed({
            ARouter.getInstance().build(RoutePath.Home.HOME_ACTIVITY).navigation()
            finish()
        }, animDuration)
    }

    /**
     * 背景图放大动画
     */
    fun scaleAnim() {
        AnimUtils.startScaleAnim(ivSplashBg, animDuration, 1.0f, 1.05f)
    }
}