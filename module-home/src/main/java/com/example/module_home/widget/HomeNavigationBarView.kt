package com.example.module_home.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.example.module_home.R

/**
 * create by apple
 * create on 2020/8/7
 * description 首页主菜单view
 */
class HomeNavigationBarView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    var view: View? = null
    var ivHomePage: View? = null
    var ivCommunity: View? = null

    init {
        view = LayoutInflater.from(context).inflate(R.layout.view_home_navigationbar, this, true)
        
    }
}