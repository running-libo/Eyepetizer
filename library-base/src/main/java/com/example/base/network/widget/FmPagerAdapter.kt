package com.example.base.network.widget

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.*

/**
 * create by libo
 * create on 2018/11/16
 * description 通用fragmentadapter
 */
class FmPagerAdapter(fm: FragmentManager?, private val tabFragments: ArrayList<Fragment>, private val titles: Array<String>) : FragmentPagerAdapter(fm!!) {

    override fun getItem(position: Int): Fragment {
        return tabFragments[position]
    }

    override fun getCount(): Int {
        return tabFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

}