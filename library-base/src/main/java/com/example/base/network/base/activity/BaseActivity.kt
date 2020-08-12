package com.example.base.network.base.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.base.R
import com.example.base.network.base.view.IBaseView
import com.example.base.network.utils.ActivityManager
import com.gyf.immersionbar.ImmersionBar

/**
 * create by libo
 * create on 2020/8/7
 * description BaseActivity
 */
open abstract class BaseActivity : AppCompatActivity(), IBaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        //统一设置activity竖屏
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)

        setContentView(setLayoutId())

        ActivityManager.addActivity(this) //创建Activity入栈管理

        statusBaySetting()
    }

    /**
     * activity系统状态栏封装，并设置默认样式
     */
    open fun statusBaySetting() {
        lifecycle.addObserver(object: LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate() {
                ImmersionBar.with(this@BaseActivity)
                        .statusBarColor(statusBarColor())
                        .statusBarDarkFont(isDarkFont())
                        .fitsSystemWindows(true)
                        .init()
            }
        })
    }

    protected abstract fun setLayoutId(): Int

    /**
     * 设置系统状态栏颜色
     */
    open fun statusBarColor(): Int = R.color.colorPrimary

    /**
     * 设置状态栏颜色，默认黑色
     */
    open fun isDarkFont(): Boolean = true

    override fun showToast() {}

    override fun showLoading() {}

    override fun showEmpty() {}

    override fun onDestroy() {
        super.onDestroy()
        ActivityManager.removeActivity(this) //销毁Activity移出栈
    }
}