package com.example.module_home

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.base.network.base.activity.BaseMvvmActivity
import com.example.base.network.route.RoutePath
import com.example.module_home.databinding.ActivityMainBinding

@Route(path = RoutePath.Home.HOME_ACTIVITY)
class MainActivity : BaseMvvmActivity<ActivityMainBinding, HomeViewModel>() {
    /** 连续按返回键退出时间  */
    private val EXIT_TIME = 2000
    /** 上次点击返回键时间  */
    private var lastTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.baseLiveData.loadSuccess.observe(this, Observer {

        })
    }

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

}