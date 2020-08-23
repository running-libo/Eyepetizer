package com.example.module_community

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.base.network.base.fragment.BaseLazyloadFragment
import com.example.base.network.route.RoutePath
import com.example.base.network.widget.FmPagerAdapter
import kotlinx.android.synthetic.main.fragment_community.*
import java.util.ArrayList

@Route(path = RoutePath.Community.COMMUNICATION_FRAGMENT)
class CommunityFragment : BaseLazyloadFragment() {
    lateinit var recomendFragment: RecomendFragment
    lateinit var focusFragment: FocusFragment
    private val fragments = ArrayList<Fragment>()

    private val titleStr by lazy {
        arrayOf(getString(R.string.recommend), getString(R.string.focus))
    }

    override fun getContentView(inflater: LayoutInflater, container: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.fragment_community, container, false)
    }

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
        recomendFragment = RecomendFragment()
        focusFragment = FocusFragment()

        fragments.add(recomendFragment)
        fragments.add(focusFragment)

        viewPager.adapter = FmPagerAdapter(childFragmentManager, fragments, titleStr)
        tablayout.setupWithViewPager(viewPager)
    }

}