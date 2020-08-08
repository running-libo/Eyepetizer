package com.example.base.network.utils

import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.example.base.R
import com.example.base.network.application.BaseApplication

/**
 * create by apple
 * create on 2020/8/8
 * description Toast工具类
 */
class ToastUtil {

    companion object {
        private var mToast: Toast? = null
        private var textView: TextView? = null
        private var showContent: String? = null
        private var isShow = false
        private var rlContainer: RelativeLayout? = null

        private val mHandler = Handler(Looper.getMainLooper())

        private val hide = Runnable {
            if (mToast != null) {
                mToast!!.cancel()
                mToast = null
            }
            textView = null
            isShow = false
        }

        private val show = Runnable {
            if (mToast == null) {  //只有mToast==null时才重新创建，否则只需更改提示文字
                val view: View = LayoutInflater.from(BaseApplication.instance).inflate(R.layout.customview_toast, null) //自定义布局
                textView = view.findViewById(R.id.toastMessage) //显示的提示文字
                rlContainer = view.findViewById(R.id.rl_toast_container)
                setLayoutParams()
                mToast = Toast(BaseApplication.instance)
                mToast!!.duration = Toast.LENGTH_SHORT
                mToast!!.setGravity(Gravity.CENTER, 0, 0)
                mToast!!.view = view
                showAnim(textView)
            }
            textView!!.text = showContent
            mToast!!.show()
            isShow = true
        }

        private fun setLayoutParams() {
            val layoutParams = rlContainer!!.layoutParams as LinearLayout.LayoutParams
            layoutParams.height = ScreenUtils.dp2px(BaseApplication.instance!!, 300f)
            rlContainer!!.layoutParams = layoutParams
        }

        /**
         * toast加上动画
         */
        fun showAnim(view: View?) {
            AnimUtils.alphaAnim(view!!, 0 / 5f, 1f, 500)
            AnimUtils.translationAnim(view, 300, 0f, 0f, ScreenUtils.dp2px(BaseApplication.instance!!, 600f).toFloat(), 0f)
            AnimUtils.startScaleAnim(view, 500, 0.5f, 1f)
        }

        /**
         * Toast 提示
         */
        @Synchronized
        fun show(message: String?) {
            if (isShow) return
            showContent = message
            mHandler.post(show)
            mHandler.postDelayed(hide, 2500) //延迟1秒隐藏toast
        }
    }

}