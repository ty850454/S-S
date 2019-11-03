package com.dreammakerteam.ss.ssweb.config;

import com.dreammakerteam.ss.core.sdk.utils.JacksonUtil;
import com.dreammakerteam.ss.core.sdk.web.HttpResponse;
import com.dreammakerteam.ss.core.sdk.web.HttpResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.servlet.http.HttpServletRequest;


/**
 * 全局统一异常处理
 *
 * @author xy
 */
@ControllerAdvice
@Slf4j
public class BaseYlExceptionHandler implements ResponseBodyAdvice {

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

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return aClass == MappingJackson2HttpMessageConverter.class || aClass == StringHttpMessageConverter.class;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
            Object r = HttpResponse.success(o);
        if (aClass == StringHttpMessageConverter.class) {
            serverHttpResponse.getHeaders().setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
            r = JacksonUtil.toJson(r);
        }
        return r;
    }
}
