package com.example.base.network.utils

import android.app.Activity
import android.content.Context
import android.os.Process
import java.util.*

/**
 * create by libo
 * create on 2018/11/15
 * description Activity出入栈管理类
 */
object ActivityManager {
    /**
     * 用于存储和统一销毁一套操作的Activities
     */
    private var activities: Stack<Activity>? = null

    /**
     * 将创建的activity入栈管理
     *
     * @param activity
     */
    fun addActivity(activity: Activity) {
        if (activities == null) {
            activities = Stack()
        }
        activities!!.add(activity)
    }

    /**
     * 将该activity出栈
     *
     * @param activity
     */
    fun removeActivity(activity: Activity?) {
        if (activity != null) {
            activities!!.remove(activity)
            activity.finish()
        }
    }

    /**
     * 结束所有activity
     */
    fun finishAll() {
        for (activity in activities!!) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities!!.clear()
        Process.killProcess(Process.myPid())
    }

    /**
     * 退出程序并杀死任务栈
     * @param context
     */
    fun exitApp(context: Context?) {
        // 结束进程
        System.exit(0)
    }
}