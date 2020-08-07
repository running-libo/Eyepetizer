package com.example.module_home.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.example.module_home.R
import kotlinx.android.synthetic.main.view_home_navigationbar.view.*

/**
 * create by apple
 * create on 2020/8/7
 * description 首页主菜单view
 */
class HomeNavigationBarView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    var view: View = LayoutInflater.from(context).inflate(R.layout.view_home_navigationbar, this, true)

    init {

        setOnClickListener(ivHome, ivCommunity, ivNotification, ivMine) {
            clearBtnState()

            when(this) {
                ivHome -> {
                    ivHome.isSelected = true
                }

                ivCommunity -> {
                    ivCommunity.isSelected = true
                }

                ivNotification -> {
                    ivNotification.isSelected = true
                }

                ivMine -> {
                    ivMine.isSelected = true
                }

            }
        }
    }

    /**
     * 恢复各个按钮点中状态
     */
    private fun clearBtnState() {
        ivHome.isSelected = false
        ivCommunity.isSelected = false
        ivNotification.isSelected = false
        ivMine.isSelected = false
    }

    /**
     * 设置多个view点击事件
     */
    fun setOnClickListener(vararg v: View?, block: View.() -> Unit) {
        val listener = OnClickListener { it.block() }
        v.forEach { it?.setOnClickListener(listener) }
    }
}