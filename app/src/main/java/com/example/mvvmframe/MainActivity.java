package com.example.mvvmframe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.mvvmframe.bean.DataResponse;
import com.example.mvvmframe.network.ApiCallBack;
import com.example.mvvmframe.network.ApiManager;
import com.google.gson.Gson;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}