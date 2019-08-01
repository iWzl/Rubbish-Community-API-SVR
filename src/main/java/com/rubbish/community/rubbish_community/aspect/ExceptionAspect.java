package com.rubbish.community.rubbish_community.aspect;

import com.rubbish.community.rubbish_community.bean.vo.common.ServiceResponseMessage;
import com.rubbish.community.rubbish_community.utils.basic.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ValidationException;

/**
 * 服务器的统一异常处理器，所有服务器在Controller抛出的异常都会在这里处理
 *
 * @author Leo Wang
 * @version 1.0
 * @date 2019/7/25 22:01
 */

@RestControllerAdvice
public class ExceptionAspect {
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 400异常
     * NoHandlerFoundException 需要Servlet API支持
     * 客户端请求的语法错误，服务器无法理解
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ServiceResponseMessage handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        log.error("不能正确读取JSON数据", e);
        return ServiceResponseMessage.createByFailCodeMessage("不能正确读取JSON数据");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ServiceResponseMessage handleValidationException(MethodArgumentNotValidException e) {
        log.error("方法参数验证失败", e);
        return ServiceResponseMessage.createByFailCodeMessage("方法参数验证失败");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ServiceResponseMessage handleValidationException(ValidationException e) {
        log.error("参数验证失败", e);
        return ServiceResponseMessage.createByFailCodeMessage("参数校验失败");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ServiceResponseMessage handlerNotFoundException(NoHandlerFoundException e) {
        log.error("请求的接口", e);
        return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.NOT_FOUND,"请求的接口不存在");
    }

    /**
     * 405异常
     * 需要Servlet API支持
     * 客户端请求中的方法被禁止
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ServiceResponseMessage handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e) {
        log.error("请求方法类型不支持", e);
        return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.METHOD_NOT_ALLOWED, "请求方法类型不支持");
    }


    /**
     * 415 异常
     * 需要Servlet API支持
     * 服务器无法处理请求附带的媒体格式
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public ServiceResponseMessage handleHttpMediaTypeNotSupportedException(Exception e) {
        log.error("内容类型不支持", e);
        return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.UNSUPPORTED_MEDIA_TYPE, "内容类型不支持");
    }


    /**
     * 500 异常
     * 最大的异常处理
     * 服务器内部错误，无法完成请求
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ServiceResponseMessage handleException(Exception e) {
        log.error("网络服务器异常", e);
        return ServiceResponseMessage.createByFailCodeMessage(ResultCodeEnum.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
