package com.example.base.network.application

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.example.base.BuildConfig
import com.example.base.R
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.scwang.smartrefresh.header.MaterialHeader
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter

/**
 * create by libo
 * create on 2020/8/4
 * description Application
 */
class BaseApplication : Application() {

    companion object {
        var instance: Application? = null
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        initARouter()

        initSmartRefreshLayout()

        Logger.addLogAdapter(AndroidLogAdapter())
    }

    /**
     * 初始化路由
     */
    fun initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    /**
     * 初始化刷新加载
     */
    fun initSmartRefreshLayout() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(fun(
                context: Context,
                layout: RefreshLayout
        ): RefreshHeader {
            layout.setEnableHeaderTranslationContent(true)
            return MaterialHeader(context).setColorSchemeResources(
                    R.color.blue,
                    R.color.blue,
                    R.color.blue
            )
        })

        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            return@setDefaultRefreshFooterCreator ClassicsFooter(context)
        }
    }

}