package com.example.module_notice.net

import com.example.module_notice.response.PushResponse
import com.example.network.interceptor.service.Api
import com.example.network.interceptor.service.ApiManager
import retrofit2.http.GET
import rx.Observable

/**
 * create by apple
 * create on 2020/8/23
 * description
 */
interface INoticeService {

    companion object {
        val instance = ApiManager.retrofit.create(INoticeService::class.java)

        fun invoke(): INoticeService {
            return instance
        }
    }

    /**
     * 推送
     */
    @GET(Api.PUSH)
    fun getPushData(): Observable<PushResponse>

}