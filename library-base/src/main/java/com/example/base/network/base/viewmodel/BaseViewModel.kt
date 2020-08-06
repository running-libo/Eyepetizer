package com.example.base.network.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 * create by libo
 * create on 2020/8/4
 * description viewModel基类
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    /** 请求成功通知  */
    var loadSuccess = MutableLiveData<Boolean>()
        protected set

    /** 请求失败通知  */
    var loadFail = MutableLiveData<Boolean>()
        protected set

}