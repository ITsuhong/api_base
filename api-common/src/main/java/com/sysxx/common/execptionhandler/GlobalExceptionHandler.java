package com.sysxx.common.execptionhandler;

import com.sysxx.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e) {
        System.out.println("发生异常了" + e);
        return AjaxResult.error(500, String.valueOf(e));

    }
}
