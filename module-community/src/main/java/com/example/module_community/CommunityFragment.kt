package com.example.module_community

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.base.network.base.fragment.BaseLazyloadFragment
import com.example.base.network.route.RoutePath

@Route(path = RoutePath.Community.COMMUNICATION_FRAGMENT)
class CommunityFragment : BaseLazyloadFragment() {

    override fun getContentView(inflater: LayoutInflater, container: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.fragment_community, container, false)
    }

    override fun initView() {

    }

}