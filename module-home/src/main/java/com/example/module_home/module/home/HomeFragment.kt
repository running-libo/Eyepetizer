package com.example.module_home.module.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    var findFragment: FindFragment? = null
    var recommendFragment: RecommendFragment? = null
    var dailyFragment: DailyFragment? = null

    override fun initView() {
        setTabLayout()
    }

    override fun getContentView(inflater: LayoutInflater, container: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.fragment_home, container, false)
    }

    /**
     * 设置tablayout子fragment
     */
    private fun setTabLayout() {
        for (i in titleStr.indices) {
            tablayout.addTab(tablayout.newTab().setText(titleStr[i]))
        }
        findFragment = FindFragment()
        recommendFragment = RecommendFragment()
        dailyFragment = DailyFragment()

        fragments.add(findFragment!!)
        fragments.add(recommendFragment!!)
        fragments.add(dailyFragment!!)

        vpHome.adapter = FmPagerAdapter(childFragmentManager, fragments, titleStr)
        tablayout.setupWithViewPager(vpHome)
    }

}