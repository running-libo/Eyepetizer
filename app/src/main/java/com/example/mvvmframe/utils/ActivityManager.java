package com.example.mvvmframe.utils;

import android.app.Activity;
import android.content.Context;
import java.util.Stack;

/**
 * create by libo
 * create on 2018/11/15
 * description Activity出入栈管理类
 */
public class ActivityManager {

    /**
     * 用于存储和统一销毁一套操作的Activities
     */
    private static Stack<Activity> activities;
    private static ActivityManager instance = new ActivityManager();

    private ActivityManager() {

    }

    public static ActivityManager getInstance() {
        return instance;
    }

    /**
     * 将创建的activity入栈管理
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        if (activities == null) {
            activities = new Stack<>();
        }
        activities.add(activity);
    }

    /**
     * 将该activity出栈
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        if (activity != null) {
            activities.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束所有activity
     */
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activities.clear();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    /**
     * 退出程序并杀死任务栈
     * @param context
     */
    public static void exitApp(Context context) {
        // 结束进程
         System.exit(0);
    }
}
