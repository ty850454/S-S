package com.dreammakerteam.ss.ssweb.wx.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginRes {
    private String openid;
    private String session_key;
}
