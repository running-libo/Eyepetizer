package com.example.mvvmframe.network;

import com.example.mvvmframe.bean.DataResponse;
import retrofit2.http.GET;
import rx.Observable;
import static com.example.mvvmframe.config.AppConfig.isDebug;

/**
 * create by libo
 * create on 2018/11/13
 * description Retrofit调用接口方法
 */
public interface ApiService {

    /** *******************************************  IP配置  ******************************************** */

    /** 正式服务器地址 */
    String SERVER_ADDRESS_RELEASE = "http://baobab.kaiyanapp.com/api/";

    /** 测试服务器地址 */
    String SERVER_ADDRESS_DEBUG = "http://baobab.kaiyanapp.com/api/";

    /** 服务器域名 */
    String SERVER_ADDRESS = isDebug ? SERVER_ADDRESS_DEBUG : SERVER_ADDRESS_RELEASE;

    @GET(Api.URL)
    Observable<DataResponse> getData();
}
