package com.example.module_home.net

import com.example.network.interceptor.service.Api
import com.example.network.interceptor.service.ApiManager
import retrofit2.http.GET
import rx.Observable

/**
 * create by libo
 * create on 2020/8/7
 * description
 */
interface IHomeService {

    @GET(Api.URL)
    fun getData(): Observable<DataResponse>

    companion object {
        val instance = ApiManager.retrofit.create(IHomeService::class.java)
        fun invoke(): IHomeService {
            return instance
        }
    }
}