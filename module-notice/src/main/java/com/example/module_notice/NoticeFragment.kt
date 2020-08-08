package com.example.module_notice

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.base.network.base.fragment.BaseLazyloadFragment
import com.example.base.network.route.RoutePath

@Route(path = RoutePath.Notification.NOTIFICATION_FRAGMENT)
class NoticeFragment : BaseLazyloadFragment() {

    override fun setLayoutId(): Int = R.layout.fragment_notice

    override fun initView() {

    }

}