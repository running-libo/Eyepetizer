package com.example.module_notice.response

import com.example.base.network.base.response.BaseResponse
import com.example.base.network.bean.PushBean

/**
 * create by apple
 * create on 2020/8/23
 * description
 */
data class PushResponse(var messageList: ArrayList<PushBean>) : BaseResponse()