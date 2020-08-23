package com.example.module_notice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.base.network.base.fragment.BaseLazyloadFragment
import com.example.base.network.route.RoutePath
import com.example.base.network.widget.FmPagerAdapter
import kotlinx.android.synthetic.main.fragment_notice.*
import java.util.ArrayList

@Route(path = RoutePath.Notification.NOTIFICATION_FRAGMENT)
class NoticeFragment : BaseLazyloadFragment() {
    lateinit var pushFragment: InteractionFragment
    lateinit var interactionFragment: InteractionFragment
    lateinit var privateLetterFragment: InteractionFragment
    private val fragments = ArrayList<Fragment>()

    private val titleStr by lazy {
        arrayOf(getString(R.string.push), getString(R.string.interaction), getString(R.string.private_letter))
    }

    override fun getContentView(inflater: LayoutInflater, container: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.fragment_notice, container, false)
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
        pushFragment = InteractionFragment()
        interactionFragment = InteractionFragment()
        privateLetterFragment = InteractionFragment()

        fragments.add(pushFragment)
        fragments.add(interactionFragment)
        fragments.add(privateLetterFragment)

        viewPager.adapter = FmPagerAdapter(childFragmentManager, fragments, titleStr)
        tablayout.setupWithViewPager(viewPager)
    }

}