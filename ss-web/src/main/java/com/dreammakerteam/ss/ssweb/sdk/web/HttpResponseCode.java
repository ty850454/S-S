package com.dreammakerteam.ss.ssweb.sdk.web;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应code
 *
 * @author xy
 */
@Getter
@AllArgsConstructor
public enum HttpResponseCode {

    /** 成功 */
    SUCCESS("0", null),

    A_90010("90010", "服务已下架"),
    A_90011("90011", "无效的服务"),
    A_90012("90012", "该服务已使用完毕"),

    B_90110("90110", "微信登陆失败"),

    ;
    private String code;
    private String msg;

}
