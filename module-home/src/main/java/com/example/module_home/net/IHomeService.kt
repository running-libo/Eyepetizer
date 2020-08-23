package com.example.module_home.net

import com.example.base.network.bean.CommomItemResponse
import com.example.network.interceptor.service.Api
import com.example.network.interceptor.service.ApiManager
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * create by libo
 * create on 2020/8/7
 * description
 */
interface IHomeService {

    companion object {
        val instance = ApiManager.retrofit.create(IHomeService::class.java)

        fun invoke(): IHomeService {
            return instance
        }
    }

    /**
     * 首页-发现
     */
    @GET(Api.FIND)
    fun getFindData(): Observable<CommomItemResponse>

    /**
     * 首页-日报
     */
    @GET(Api.DAILY)
    fun getDailyData(@Query("num") num: Int): Observable<CommomItemResponse>

    /**
     * 首页-推荐
     */
    @GET(Api.HOME_RECOMMEND)
    fun getRecommend(@Query("page") page: Int): Observable<CommomItemResponse>

}