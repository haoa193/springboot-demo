package com.haoa193.springbootdemo.exception;

/**
 * @author shenlou  2017/11/1
 */
public enum BizExceptionCodeEnum {

    EX_ORDER_UNKNOWN_SHELF(5005, "非法的货架编号"),

    EX_USER_ILLEGAL(6001, "不能删除当前登录用户"),
    EX_USER_ACCOUNT_INVALID(6002, "账号不存在"),
    EX_USER_PWD_INVALID(6002, "账号密码不正确"),

    EX_COUPONS_TEMP_REPEAT(6003, "重复的优惠券模板"),
    EX_COUPONS_TEMP_STARTONE(6004, "同种类型的优惠券只能启用一个"),

    EX_ROLE_IN_USE(7004, "当前角色正在使用中，不能删除"),
    ;

    BizExceptionCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
