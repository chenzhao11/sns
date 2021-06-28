package com.jee.homework.sns.common.handler;

import com.jee.homework.sns.common.base.ResultVo;
import com.jee.homework.sns.common.constant.ResultCode;
import com.jee.homework.sns.common.exception.APIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 *Author: zhaochen
 *Date: 2021/6/28
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(APIException.class)
    public ResultVo APIExceptionHandler(APIException e){
        return new ResultVo(e.getCode(), e.getMsg(), e.getMessage());
    }


    //validater的错误信息
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        log.warn(e.getMessage(), e);
        // 返回错误信息
        return new ResultVo(ResultCode.ARGUMENT_ERRO.getCode(),ResultCode.ARGUMENT_ERRO.getMsg(), objectError.getDefaultMessage());
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResultVo ExceptionHandler(Exception e){
        log.error(e.getMessage());
        return new ResultVo(ResultCode.SERVER_INNER_ERRO.getCode(),ResultCode.SERVER_INNER_ERRO.getMsg(), e.getMessage());
    }
}
