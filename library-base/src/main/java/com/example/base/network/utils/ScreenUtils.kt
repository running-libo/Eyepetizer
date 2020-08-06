package com.example.base.network.utils

import android.content.Context
import android.graphics.Point
import android.util.TypedValue
import android.view.WindowManager

/**
 * create by libo
 * create on 2018/11/20
 * description 屏幕尺寸转换工具类
 */
object ScreenUtils {
    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    fun getScreenWidth(context: Context): Int {
        return context.resources.displayMetrics.widthPixels
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     * @return
     */
    fun getScreenHeight(context: Context): Int {
        return context.resources.displayMetrics.heightPixels
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    fun getStatusBarHeight(context: Context): Int {
        var statusBarHeight = 0
        val res = context.resources
        val resourceId = res.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId)
        }
        return statusBarHeight
    }

    /**
     * 获取屏幕宽高，不包含navigationbar的高度
     *
     * @param context
     * @return
     */
    fun getDisplayWithoutNavigationBar(context: Context): IntArray {
        val display = IntArray(2)
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val defaultDisplay = wm.defaultDisplay
        val p = Point()
        defaultDisplay.getSize(p)
        display[0] = p.x
        display[1] = p.y
        return display
    }

    /**
     * 获取屏幕密度
     *
     * @param context
     * @return
     */
    fun getScreenDensity(context: Context): Float {
        return context.resources.displayMetrics.density
    }

    /**
     * dp转px
     *
     * @param context
     * @param dpValue
     * @return
     */
    fun dp2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * px转dp
     *
     * @param context
     * @param pxVal
     * @return
     */
    fun px2dp(context: Context, pxVal: Float): Float {
        val scale = context.resources.displayMetrics.density
        return pxVal / scale
    }

    /**
     * sp转px
     *
     * @param context
     * @param spVal
     * @return
     */
    fun sp2px(context: Context, spVal: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.resources.displayMetrics).toInt()
    }

    /**
     * px转sp
     *
     * @param context
     * @param pxVal
     * @return
     */
    fun px2sp(context: Context, pxVal: Float): Float {
        return pxVal / context.resources.displayMetrics.scaledDensity
    }
}