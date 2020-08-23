package com.example.module_community.net

import com.example.base.network.bean.CommomItemResponse
import com.example.network.interceptor.service.Api
import com.example.network.interceptor.service.ApiManager
import retrofit2.http.GET
import rx.Observable

/**
 * create by apple
 * create on 2020/8/24
 * description
 */
interface ICommunityService {

    companion object {
        val instance = ApiManager.retrofit.create(ICommunityService::class.java)

        fun invoke(): ICommunityService {
            return instance
        }
    }

    /**
     * 关注
     */
    @GET(Api.FOCUS)
    fun getFocusList(): Observable<CommomItemResponse>

    /**
     * 推荐
     */
    @GET(Api.COMMUNITY_RECOMMEND)
    fun getRecommendData(): Observable<CommomItemResponse>
}