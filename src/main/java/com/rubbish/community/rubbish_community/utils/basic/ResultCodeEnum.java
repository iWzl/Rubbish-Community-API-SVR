package com.rubbish.community.rubbish_community.utils.basic;

/**
 * 消息返回码的统一定义
 *
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/27 11:06
 */
public enum ResultCodeEnum {

    //请求成功,伴随返回值
    SUCCESS(200),
    //请求成功，创建新的资源
    SUCCESS_CREATED(201),
    //请求成功，没有返回值
    SUCCESS_NO_CONTENT(204),
    //请求成功，重置内容
    SUCCESS_RESET_CONTENT(205),

    //客户端请求的语法错误，服务器无法理解
    BAD_REQUEST(400),
    //请求要求用户的身份认证
    UNAUTHORIZED(401),
    //服务器理解请求客户端的请求，但是拒绝执行此请求
    FORBIDDEN(403),
    //服务器无法根据客户端的请求找到资源(网页)
    NOT_FOUND(404),
    //客户端请求中的方法被禁止
    METHOD_NOT_ALLOWED(405),
    //服务器无法根据客户端请求的内容特性完成请求
    NOT_ACCEPTABLE(406),
    //客户端请求信息的先决条件错误
    PRECONDITION_FAILED(412),
    //服务器无法处理请求附带的媒体格式
    UNSUPPORTED_MEDIA_TYPE(415),
    //服务器无法满足Expect的请求头信息
    EXPECTATION_FAILED(417),

    //服务器内部错误，无法完成请求
    INTERNAL_SERVER_ERROR(500),
    ;



    private int code;
    ResultCodeEnum(int code){
        this.code = code;
    }
    public int getCode() {
        return this.code;
    }
}
