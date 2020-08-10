package com.example.base.network.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.base.network.base.view.IBaseView

/**
 * create by libo
 * create on 2018/11/16
 * description 懒加载Fragment，默认所有fragment都是懒加载
 */
abstract class BaseLazyloadFragment : Fragment() {
    protected var rootView: View? = null
    private var canVisible = false
    /** 是否是第一次加载布局  */
    private var isInitView = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initLoadMoreViews()
        isInitView = true
        isCanLoadData

        isVisible()
        return getContentView(layoutInflater, container)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initData()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        //isVisibleToUser值表示:该Fragment的UI用户是否可见，获取该标志记录下来
        if (isVisibleToUser) {
            canVisible = true
            isCanLoadData
        } else {
            canVisible = false
        }
    }

    //所以能加载数据条件是view初始化完成并且对用户可见
    private val isCanLoadData: Unit
        private get() {
            //所以能加载数据条件是view初始化完成并且对用户可见
            if (canVisible && isInitView) {
                loadData()
                canVisible = false
                isInitView = false
            }
        }

    protected abstract fun initView()

    protected fun initData() {}

    protected fun initLoadMoreViews() {}

    /**
     * 懒加载方法
     */
    protected fun loadData() {}

    abstract fun getContentView(inflater: LayoutInflater, container: ViewGroup?): View

//    override fun showToast() {}
//
//    override fun showLoading() {}
//
//    override fun showEmpty() {}
}