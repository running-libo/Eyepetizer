package com.example.base.network.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.base.network.base.livedata.BaseLiveData

/**
 * create by apple
 * create on 2020/8/9
 * description 项目所有viewModel基类
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    var baseLiveData = BaseLiveData()


}