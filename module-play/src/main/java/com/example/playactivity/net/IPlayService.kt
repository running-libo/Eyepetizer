package com.example.playactivity.net

import com.example.network.interceptor.service.Api
import com.example.network.interceptor.service.ApiManager
import retrofit2.http.*
import rx.Observable

/**
 * create by apple
 * create on 2020/8/12
 * description
 */
interface IPlayService {

    companion object {
        val instance = ApiManager.retrofit.create(IPlayService::class.java)

        fun invoke(): IPlayService {
            return instance
        }
    }

    /**
     * 视频播放详情页
     */
    @GET(Api.PLAY_DETAIL)
    fun getPlayDetailData(@Path("id") videoId: Int): Observable<PlayDetailResponse>

    /**
     * 相关视频列表
     */
    @GET(Api.RELATE_VIDEO)
    fun getRelateVideos(@Query("id") videoId: Int): Observable<RelateVideoResponse>

    /**
     * 评论列表
     */
    @GET(Api.COMMENT_LIST)
    fun getCommentList(@Query("videoId") videoId: Int): Observable<CommentResponse>
}