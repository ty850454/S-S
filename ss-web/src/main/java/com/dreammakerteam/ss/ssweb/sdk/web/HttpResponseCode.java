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

    ;
    private String code;
    private String msg;

}
