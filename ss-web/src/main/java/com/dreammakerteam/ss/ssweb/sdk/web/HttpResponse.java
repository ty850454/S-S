package com.dreammakerteam.ss.ssweb.sdk.web;


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
    public HttpResponse<?> success() {
        return success(null, null);
    }

    @SuppressWarnings("unused")
    public HttpResponse<T> success(String msg) {
        return success(msg, null);
    }

    @SuppressWarnings({"unused", "WeakerAccess"})
    public HttpResponse<T> success(String msg, T data) {
        HttpResponse<T> response = new HttpResponse<>();
        response.setCode(HttpResponseCode.SUCCESS.getCode());
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    @SuppressWarnings("unused")
    public HttpResponse<?> failure(HttpResponseCode responseCode) {
        return new HttpResponse<>();
    }

}
