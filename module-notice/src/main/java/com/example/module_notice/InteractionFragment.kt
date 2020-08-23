package com.example.module_notice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.launcher.ARouter
import com.example.base.network.base.fragment.BaseLazyloadFragment
import com.example.base.network.route.RoutePath
import kotlinx.android.synthetic.main.fragment_interaction.*

class InteractionFragment : BaseLazyloadFragment() {

    override fun initView() {
        tvLogin.setOnClickListener {
            ARouter.getInstance().build(RoutePath.Login.LOGIN_ACTIVITY).navigation()
        }
    }

    override fun getContentView(inflater: LayoutInflater, container: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.fragment_interaction, container, false)
    }

}