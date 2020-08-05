package com.example.base.network.base

import com.example.base.network.config.AppConfig
import java.io.Serializable

/**
 * create by libo
 * create on 2018/11/13
 * description  请求数据实体类基类
 */
open class BaseModel<T> : Serializable {
    /** 自定义错误码  */
    var code: String? = null

    /** 自定义业务状态码  */
    var bizcode: String? = null

    /** 消息提示  */
    var msg: String? = null

    /** 泛型实体类  */
    var data: T? = null
    val isOk: Boolean
        get() = bizcode == AppConfig.BIZCODE_OK
}