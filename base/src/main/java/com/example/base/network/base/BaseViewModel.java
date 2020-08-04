package com.example.base.network.base;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * create by libo
 * create on 2020/8/4
 * description viewModel基类
 */
public class BaseViewModel extends AndroidViewModel {
    /** 请求成功通知 */
    protected MutableLiveData<Boolean> loadSuccess = new MutableLiveData<>();
    /** 请求失败通知 */
    protected MutableLiveData<Boolean> loadFail = new MutableLiveData<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Boolean> getLoadSuccess() {
        return loadSuccess;
    }

    public MutableLiveData<Boolean> getLoadFail() {
        return loadFail;
    }
}
