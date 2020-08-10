package com.example.module_home.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.module_home.R
import kotlinx.android.synthetic.main.view_home_navigationbar.view.*

/**
 * create by libo
 * create on 2020/8/7
 * description 首页主菜单view
 */
class HomeNavigationBarView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    var view: View = LayoutInflater.from(context).inflate(R.layout.view_home_navigationbar, this, true)
    var onSelectListener: OnSelectListener? = null
    lateinit var tvHomeTab: TextView
    lateinit var tvCommunityTab: TextView
    lateinit var tvNotificationTab: TextView
    lateinit var tvMineTab: TextView

    init {

        initView()

        setOnClickListener(ivHome, ivCommunity, ivRelease, ivNotification, ivMine) {
            clearBtnState()

            when(this) {
                ivHome -> {
                    ivHome.isSelected = true
                    tvHomeTab.isSelected = true
                    onSelectListener!!.onSelected(0)
                }

                ivCommunity -> {
                    ivCommunity.isSelected = true
                    tvCommunityTab.isSelected = true
                    onSelectListener!!.onSelected(1)
                }

                ivRelease -> {
                    ivRelease.isSelected = true
                    onSelectListener!!.onSelected(2)
                }

                ivNotification -> {
                    ivNotification.isSelected = true
                    tvNotificationTab.isSelected =true
                    onSelectListener!!.onSelected(3)
                }

                ivMine -> {
                    ivMine.isSelected = true
                    tvMineTab.isSelected = true
                    onSelectListener!!.onSelected(4)
                }

            }
        }
    }

    fun initView() {
        tvHomeTab = view.findViewById(R.id.tvHome)
        tvCommunityTab = view.findViewById(R.id.tvCommunity)
        tvNotificationTab = view.findViewById(R.id.tvNotification)
        tvMineTab = view.findViewById(R.id.tvMine)
    }

    /**
     * 恢复各个按钮点中状态
     */
    private fun clearBtnState() {
        ivHome.isSelected = false
        tvHomeTab.isSelected = false
        ivCommunity.isSelected = false
        tvCommunityTab.isSelected = false
        ivRelease.isSelected = false
        ivNotification.isSelected = false
        tvNotificationTab.isSelected = false
        ivMine.isSelected = false
        tvMineTab.isSelected = false
    }

    /**
     * 设置首页为默认选中
     */
    fun setDefaultPage() {
        ivHome.performClick()
    }

    /**
     * 设置多个view点击事件
     */
    fun setOnClickListener(vararg v: View?, block: View.() -> Unit) {
        val listener = OnClickListener { it.block() }
        v.forEach { it?.setOnClickListener(listener) }
    }

    interface OnSelectListener {
        fun onSelected(pos: Int)
    }

    fun setSelectListener(onSelectListener: OnSelectListener) {
        this.onSelectListener = onSelectListener
    }
}