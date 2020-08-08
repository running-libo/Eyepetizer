package com.example.module_home.module.home

import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.base.network.base.activity.BaseMvvmActivity
import com.example.base.network.route.RoutePath
import com.example.base.network.utils.ToastUtil
import com.example.module_home.R
import com.example.module_home.databinding.ActivityMainBinding
import com.example.module_home.module.home.HomeViewModel
import com.example.module_home.widget.HomeNavigationBarView.OnSelectListener
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = RoutePath.Home.HOME_ACTIVITY)
class MainActivity : BaseMvvmActivity<ActivityMainBinding, HomeViewModel>() {
    /** 连续按返回键退出时间  */
    private val EXIT_TIME = 2000
    /** 上次点击返回键时间  */
    private var lastTime: Long = 0

    /**
     * 双击返回退出App
     */
    override fun onBackPressed() {
        if (System.currentTimeMillis() - lastTime > EXIT_TIME) {
            Toast.makeText(applicationContext, R.string.exit_app, Toast.LENGTH_SHORT).show()
            lastTime = System.currentTimeMillis()
        } else {
            super.onBackPressed()
        }
    }

    override fun init() {
        viewHomeNavigation.setSelectListener(object: OnSelectListener {
            override fun onSelected(pos: Int) {
                ToastUtil.show("当前位置${pos}")
            }
        })
    }

}