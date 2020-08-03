package com.example.mvvmframe.network;

import com.example.mvvmframe.bean.UserInfoCache;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * create by libo
 * create on 2018/11/13
 * description 统一添加header的拦截器
 */
public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("token", UserInfoCache.TOKEN);

        return chain.proceed(builder.build());
    }
}