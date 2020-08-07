package com.example.base.network.base.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.gyf.immersionbar.ImmersionBar

/**
 * create by apple
 * create on 2020/8/7
 * description BaseActivity
 */
open class BaseActivity : AppCompatActivity() {

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
}