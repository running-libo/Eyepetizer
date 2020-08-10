package com.example.base.network.base.response

import java.io.Serializable

/**
 * create by libo
 * create on 2018/11/13
 * description  请求数据实体类基类
 */
open class BaseResponse : Serializable {

    var count: Int = 0

    var total: Int = 0

    var nextPageUrl: String? = null

    var adExist: Boolean? = false
}