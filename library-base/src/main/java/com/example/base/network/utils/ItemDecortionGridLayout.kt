package com.example.base.network.utils

import android.content.Context
import android.graphics.Canvas
import androidx.recyclerview.widget.RecyclerView

/**
 * create by libo
 * create on 2018/11/29
 * description recyclerview gridlayoutManager或者staggeredLayoutManager设置间距类
 */
class ItemDecortionGridLayout : RecyclerView.ItemDecoration {
    private var mContext: Context
    private var paddingSpace = 10

    constructor(context: Context) {
        mContext = context
    }

    constructor(context: Context, paddingSpace: Int) {
        mContext = context
        this.paddingSpace = paddingSpace
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        drawVertical(c, parent)
    }

    fun drawVertical(c: Canvas?, parent: RecyclerView) {
        val childCount = parent.childCount

        // 在每一个子控件的右侧画线
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val tag = child.tag as String
            if (tag == null) {
                val right = child.right
                val layoutParams = child.layoutParams as RecyclerView.LayoutParams
                val M = ScreenUtils.dp2px(mContext, paddingSpace.toFloat())
                layoutParams.topMargin = M
                layoutParams.bottomMargin = M
                if (right > ScreenUtils.getScreenWidth(mContext) / 2) {
                    layoutParams.rightMargin = M
                    layoutParams.leftMargin = M / 2
                } else {
                    layoutParams.rightMargin = M / 2
                    layoutParams.leftMargin = M
                }
                child.layoutParams = layoutParams
            }
        }
    }
}