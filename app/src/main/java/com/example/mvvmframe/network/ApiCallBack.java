package com.example.mvvmframe.network;

import com.example.mvvmframe.base.BaseModel;
import com.example.mvvmframe.utils.LogUtils;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * create by libo
 * create on 2018/11/13
 * description 自定义请求数据回调和过滤
 */
public abstract class ApiCallBack<M extends BaseModel> extends Subscriber<M> {

    @Override
    public void onCompleted() { }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();

        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();

            //Http状态码提示
            if (code >=400  && code< 500) {
                LogUtils.e("请求错误");
            } else if (code >= 500) {
                LogUtils.e("服务器错误");
            }
        }
    }

    @Override
    public void onNext(M baseModel) {
        onSuccess(baseModel);
    }

    /**
     * onSuccess回调的数据为程序具体需要的业务状态码，具体数据等
     */
    public abstract void onSuccess(M m);
}