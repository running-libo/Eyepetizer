package com.example.playactivity.net

import com.example.base.network.base.response.BaseResponse

/**
 * create by apple
 * create on 2020/8/12
 * description
 */
data class RelateVideoResponse(var itemList: ArrayList<RelateVideoItemBean>) : BaseResponse() {

    data class RelateVideoItemBean(val type: String, val data: PlayDetailResponse)
}