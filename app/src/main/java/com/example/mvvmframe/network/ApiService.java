package com.example.mvvmframe.network;

import com.example.mvvmframe.bean.DataResponse;
import retrofit2.http.GET;
import rx.Observable;

/**
 * create by libo
 * create on 2018/11/13
 * description Retrofit调用接口方法
 */
public interface ApiService {

    @GET(Api.URL)
    Observable<DataResponse> getData();
}
