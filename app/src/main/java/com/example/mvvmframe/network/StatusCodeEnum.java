package com.example.mvvmframe.network;

/**
 * create by libo
 * create on 2018/11/23
 * description 自定义请求返回状态码枚举类
 */
public enum StatusCodeEnum {

    RESULT_OK("0000", "请求成功"),

    RESULT_UNLOGIN("2001", "用户未登录"),

    RESULT_NOAUTHORITY("2002", "用户权限不足"),

    RESULT_TOKENINVALID("2003", "token失效"),

    RESULT_ERROR("5000", "请求失败");

    private String tipMsg;
    private String statusCode;

    StatusCodeEnum(String statusCode, String tipMsg) {
        this.tipMsg = tipMsg;
        this.statusCode = statusCode;
    }

    public String getTipMsg() {
        return tipMsg;
    }

    public void setTipMsg(String tipMsg) {
        this.tipMsg = tipMsg;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * 通过code获取枚举对象
     * @param code
     * @return
     */
    public static StatusCodeEnum getByCode(String code) {
        StatusCodeEnum[] statusCodes = StatusCodeEnum.values();
        for (StatusCodeEnum statusCode : statusCodes) {
            if (statusCode.getStatusCode().equals(code)) {
                return statusCode;
            }
        }
        return StatusCodeEnum.RESULT_ERROR;
    }

}
