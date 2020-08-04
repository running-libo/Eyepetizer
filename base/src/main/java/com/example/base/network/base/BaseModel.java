package com.example.base.network.base;

import com.example.base.network.config.AppConfig;
import java.io.Serializable;

/**
 * create by libo
 * create on 2018/11/13
 * description  请求数据实体类基类
 */
public class BaseModel<T> implements Serializable {

    /** 自定义错误码 */
    public String code;
    /** 自定义业务状态码 */
    public String bizcode;
    /** 消息提示 */
    public String msg;
    /** 泛型实体类 */
    public T data;

    public boolean isOk() {
        return bizcode.equals(AppConfig.BIZCODE_OK);
    }
}