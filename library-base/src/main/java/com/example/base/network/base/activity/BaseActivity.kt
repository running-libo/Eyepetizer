package com.example.base.network.base.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.base.network.base.view.IBaseView
import com.gyf.immersionbar.ImmersionBar

/**
 * create by apple
 * create on 2020/8/7
 * description BaseActivity
 */
open abstract class BaseActivity : AppCompatActivity() , IBaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        //统一设置activity竖屏
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)


    }

    override fun onStart() {
        super.onStart()

        init()
    }

    /**
     * 设置activity全屏
     */
    fun fullScreen() {
        lifecycle.addObserver(object: LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate() {
                ImmersionBar.with(this@BaseActivity).init()
            }
        })
    }

    override fun init() {}

    override fun showToast() {}

    override fun showLoading() {}

    override fun showEmpty() {}
}