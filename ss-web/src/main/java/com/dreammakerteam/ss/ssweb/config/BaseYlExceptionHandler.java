package com.dreammakerteam.ss.ssweb.config;

import com.dreammakerteam.ss.core.sdk.web.HttpResponse;
import com.dreammakerteam.ss.core.sdk.web.HttpResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


/**
 * 全局统一异常处理
 *
 * @author xy
 */
@ControllerAdvice
@Slf4j
public class BaseYlExceptionHandler {

    /**
     * 处理其它异常
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpResponse handleRunTimeException(HttpServletRequest request, Exception e) {
        log.error("系统异常：{}，URL：{}", e.getMessage(), request.getRequestURI(), e);
        return HttpResponse.failure(HttpResponseCode.NONE, e.getMessage());
    }
}
