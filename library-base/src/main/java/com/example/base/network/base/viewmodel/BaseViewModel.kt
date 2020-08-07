package com.example.base.network.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.base.network.base.livedata.BaseLiveData

/**
 * create by libo
 * create on 2020/8/4
 * description viewModel基类
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    var baseLiveData = BaseLiveData()

}