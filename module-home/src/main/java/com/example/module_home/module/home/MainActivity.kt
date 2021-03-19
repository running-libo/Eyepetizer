package com.example.module_home.module.home

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.base.network.base.activity.BaseMvvmActivity
import com.example.base.network.route.RoutePath
import com.example.base.network.utils.ToastUtil
import com.example.module_home.R
import com.example.module_home.databinding.ActivityMainBinding
import com.example.module_home.viewmodel.HomeViewModel
import com.example.module_home.widget.HomeNavigationBarView.OnSelectListener
import com.example.network.BuildConfig
import com.example.network.interceptor.service.Api
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = RoutePath.Home.HOME_ACTIVITY)
class MainActivity : BaseMvvmActivity<ActivityMainBinding, HomeViewModel>() {
    /** 连续按返回键退出时间  */
    private val EXIT_TIME = 2000
    /** 上次点击返回键时间  */
    private var lastTime: Long = 0

    var homeFragment: HomeFragment? = null

    var communityFragment: Fragment? = null

    var notificationFragment: Fragment? = null

    var mineFragment: Fragment? = null

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

        //这里测试一下环境是否正确
        when (BuildConfig.CUR_ENV) {
            BuildConfig.IS_DEV -> {
                Toast.makeText(applicationContext, "开发环境", Toast.LENGTH_SHORT).show()
            }
            BuildConfig.IS_BETA -> {
                Toast.makeText(applicationContext, "测试环境", Toast.LENGTH_SHORT).show()
            }
            BuildConfig.IS_RELEASE -> {
                Toast.makeText(applicationContext, "正式环境", Toast.LENGTH_SHORT).show()
            }
            else -> ""
        }

        viewHomeNavigation.setSelectListener(object: OnSelectListener {
            override fun onSelected(pos: Int) {
                switchTab(pos)
            }
        })

        viewHomeNavigation.setDefaultPage()
    }

    override fun setLayoutId(): Int = R.layout.activity_main

    /**
     * 切换fragment
     */
    fun switchTab(pos: Int) {
        supportFragmentManager.beginTransaction().apply {
            when(pos) {
                0 -> {
                    hideAllFragments(this)
                    if (homeFragment == null) {
                        homeFragment = HomeFragment()
                        add(R.id.containerlayout, homeFragment!!)
                    } else {
                        show(homeFragment!!)
                    }
                }

                1 -> {
                    hideAllFragments(this)
                    if (communityFragment == null) {
                        communityFragment = ARouter.getInstance().build(RoutePath.Community.COMMUNICATION_FRAGMENT).navigation() as Fragment
                        add(R.id.containerlayout, communityFragment!!)
                    } else {
                        show(communityFragment!!)
                    }
                }

                2 -> {
                    ARouter.getInstance().build(RoutePath.Login.LOGIN_ACTIVITY).navigation()
                }

                3 -> {
                    hideAllFragments(this)
                    if (notificationFragment == null) {
                        notificationFragment = ARouter.getInstance().build(RoutePath.Notification.NOTIFICATION_FRAGMENT).navigation() as Fragment
                        add(R.id.containerlayout, notificationFragment!!)
                    } else {
                        show(notificationFragment!!)
                    }
                }

                4 -> {
                    hideAllFragments(this)
                    if (mineFragment == null) {
                        mineFragment = ARouter.getInstance().build(RoutePath.Mine.MINE_FRAGMENT).navigation() as Fragment
                        add(R.id.containerlayout, mineFragment!!)
                    } else {
                        show(mineFragment!!)
                    }
                }

            }
        }.commitAllowingStateLoss()
    }

    /**
     * 隐藏各个fragment
     */
    fun hideAllFragments(transation: FragmentTransaction) {
        transation.run {
            if (homeFragment != null) {
                transation.hide(homeFragment!!)
            }
            if (communityFragment != null) {
                transation.hide(communityFragment!!)
            }
            if (notificationFragment != null) {
                transation.hide(notificationFragment!!)
            }
            if (mineFragment != null) {
                transation.hide(mineFragment!!)
            }
        }
    }

}