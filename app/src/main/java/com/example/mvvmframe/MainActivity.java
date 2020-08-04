package com.example.mvvmframe;

import android.util.Log;
import com.example.mvvmframe.base.BaseActivity;
import com.example.mvvmframe.base.BaseViewModel;
import com.example.mvvmframe.bean.DataResponse;
import com.example.mvvmframe.network.ApiCallBack;
import com.example.mvvmframe.network.ApiManager;
import com.google.gson.Gson;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        ApiManager.getApiService().getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new ApiCallBack<DataResponse>() {
                    @Override
                    public void onSuccess(DataResponse dataResponse) {
                        String json = new Gson().toJson(dataResponse.getItemList());
                        Log.i("minfo", json);
                    }
                });
    }

    @Override
    protected BaseViewModel getViewModel() {
        return null;
    }
}