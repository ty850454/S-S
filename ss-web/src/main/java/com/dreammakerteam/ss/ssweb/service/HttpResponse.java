package com.dreammakerteam.ss.ssweb.service;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponse<T> {

    private String code;
    private String detail;

    private String msg;
    private T data;



    public HttpResponse<?> success() {
        return new HttpResponse<>();
    }

    public HttpResponse<?> success(T data) {
        HttpResponse<Object> response = new HttpResponse<>();
        response.setData(data);
        return response;
    }

}
