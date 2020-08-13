package com.example.module_home.module.home

import android.view.View
import androidx.lifecycle.Observer
import com.example.base.network.base.fragment.BaseMvvmFragment
import com.example.module_home.databinding.FragmentDailyBinding
import com.example.module_home.viewmodel.DailyViewModel
import kotlinx.android.synthetic.main.fragment_daily.*

class DailyFragment : BaseMvvmFragment<FragmentDailyBinding, DailyViewModel>() {

    override fun initView() {

        smartRefreshLayout.setOnRefreshListener {
            viewModel.refresh()
        }

        smartRefreshLayout.setOnLoadMoreListener {
            viewModel.loadMore()
        }

        viewModel.baseLiveData.refresh.observe(this, Observer {
            smartRefreshLayout.finishRefresh()
        })

        viewModel.baseLiveData.loadMore.observe(this, Observer {
            smartRefreshLayout.finishLoadMore()
        })

        viewModel.baseLiveData.loadFail.observe(this, Observer {
            smartRefreshLayout.finishRefresh()
            smartRefreshLayout.finishLoadMore()
        })

        viewModel.baseLiveData.switchToEmpty.observe(this, Observer {
            viewEmpty.visibility = View.VISIBLE
        })

        viewModel.baseLiveData.switchToList.observe(this, Observer {
            viewEmpty.visibility = View.GONE
        })
    }

}