package com.jee.homework.sns.common.constant;


/**
 *
 *Author: zhaochen
 *Date: 2021/6/28
 */
public enum ResultCode {
    //可以理解成指定了一些实例，这些实例都有指定的属性
    SUCCESS(200,"success"),
    SERVER_INNER_ERRO(500,"服务器内部错误"),
    ARGUMENT_ERRO(1000,"参数错误");

    private  int code;
    private String msg;
    ResultCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
    public int getCode(){
        return this.code;
    }
}
