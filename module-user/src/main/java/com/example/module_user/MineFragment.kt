package com.example.module_user

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.base.network.base.fragment.BaseLazyloadFragment
import com.example.base.network.route.RoutePath

@Route(path = RoutePath.Mine.MINE_FRAGMENT)
class MineFragment : BaseLazyloadFragment() {

    override fun setLayoutId() = R.layout.fragment_mine


    override fun initView() {

    }

}