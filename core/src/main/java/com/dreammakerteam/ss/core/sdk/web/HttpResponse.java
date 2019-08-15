package com.dreammakerteam.ss.core.sdk.web;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 响应
 *
 * @author xy
 * @param <T>
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class HttpResponse<T> {

    private String code;
    private String detail;

    private String msg;
    private T data;

    @SuppressWarnings("unused")
    public static HttpResponse<?> success() {
        return success(null, null);
    }

    @SuppressWarnings("unused")
    public static <T> HttpResponse<T> success(T data) {
        return success(null, data);
    }

    @SuppressWarnings({"unused", "WeakerAccess"})
    public static <T> HttpResponse<T> success(String msg, T data) {
        HttpResponse<T> response = new HttpResponse<>();
        response.setCode(HttpResponseCode.SUCCESS.getCode());
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    @SuppressWarnings("unused")
    public static HttpResponse<?> failure(HttpResponseCode responseCode) {
        HttpResponse<Object> response = new HttpResponse<>();
        response.setCode(responseCode.getCode());
        response.setMsg(responseCode.getMsg());
        return response;
    }

    @SuppressWarnings("unused")
    public static HttpResponse<?> failure(HttpResponseCode responseCode, Object... param) {
        HttpResponse<Object> response = new HttpResponse<>();
        response.setCode(responseCode.getCode());
        response.setMsg(String.format(responseCode.getMsg(), param));
        return response;
    }

}
