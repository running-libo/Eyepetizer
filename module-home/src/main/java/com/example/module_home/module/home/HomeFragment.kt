package com.example.module_home.module.home

import androidx.fragment.app.Fragment
import com.example.base.network.base.fragment.BaseLazyloadFragment
import com.example.base.network.widget.FmPagerAdapter
import com.example.module_home.R
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : BaseLazyloadFragment() {

    private val titleStr by lazy {
        arrayOf(getString(R.string.find), getString(R.string.recommend), getString(R.string.daily))
    }
    private val fragments = ArrayList<Fragment>()
    var findFragment: DailyFragment? = null
    var recommendFragment: DailyFragment? = null
    var dailyFragment: DailyFragment? = null

    override fun setLayoutId(): Int = R.layout.fragment_home

    override fun initView() {
        setTabLayout()
    }

    /**
     * 设置tablayout子fragment
     */
    private fun setTabLayout() {
        for (i in titleStr.indices) {
            tablayout.addTab(tablayout.newTab().setText(titleStr[i]))
        }
        findFragment = DailyFragment()
        recommendFragment = DailyFragment()
        dailyFragment = DailyFragment()

        fragments.add(findFragment!!)
        fragments.add(recommendFragment!!)
        fragments.add(dailyFragment!!)

        vpHome.adapter = FmPagerAdapter(childFragmentManager, fragments, titleStr)
        tablayout.setupWithViewPager(vpHome)
    }

}