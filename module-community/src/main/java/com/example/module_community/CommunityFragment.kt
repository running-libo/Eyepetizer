package com.example.module_community

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.base.network.base.fragment.BaseLazyloadFragment
import com.example.base.network.route.RoutePath

@Route(path = RoutePath.Community.COMMUNICATION_FRAGMENT)
class CommunityFragment : BaseLazyloadFragment() {
    override fun setLayoutId(): Int = R.layout.fragment_community

    override fun initView() {

    }

}