package com.example.base.network.utils

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.DecelerateInterpolator
import android.view.animation.TranslateAnimation

/**
 * create by apple
 * create on 2020/8/7
 * description
 */
class AnimUtils {
    /**
     * 以中心缩放属性动画
     * @param view
     * @param from
     * @param to
     */
    fun startScaleAnim(view: View?, time: Long, from: Float, to: Float) {
        val animX = ObjectAnimator.ofFloat(view, "scaleX", from, to)
        val animY = ObjectAnimator.ofFloat(view, "scaleY", from, to)
        animX.duration = time
        animY.duration = time
        animX.start()
        animY.start()
    }

    /**
     * 旋转属性动画
     * @param view
     * @param time
     * @param fromAngle
     * @param toAngle
     */
    fun startRotateAnim(view: View?, time: Long, fromAngle: Int, toAngle: Float) {
        val animRotate = ObjectAnimator.ofFloat(view, "rotation", fromAngle.toFloat(), toAngle)
        animRotate.duration = time
        animRotate.start()
    }

    /**
     * 移动动画
     * @param view
     * @param fromX
     * @param toX
     * @param fromY
     * @param toY
     */
    fun translationAnim(view: View, duration: Long, fromX: Float, toX: Float, fromY: Float, toY: Float) {
        val anim = TranslateAnimation(fromX, toX, fromY, toY)
        anim.duration = duration
        anim.fillAfter = true
        anim.interpolator = DecelerateInterpolator()
        view.startAnimation(anim)
    }

    /**
     * 透明度改变动画
     * @param view
     * @param fromAlpha
     * @param toAlpha
     * @param duration
     */
    fun alphaAnim(view: View, fromAlpha: Float, toAlpha: Float, duration: Long) {
        val anim = AlphaAnimation(fromAlpha, toAlpha)
        anim.duration = duration
        view.startAnimation(anim)
    }
}