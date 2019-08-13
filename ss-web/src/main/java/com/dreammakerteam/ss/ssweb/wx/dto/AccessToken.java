package com.dreammakerteam.ss.ssweb.wx.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Setter
@Getter
@ToString
public class AccessToken {
    private String access_token;
    private Integer expires_in;
    private Date expiresTime;

    public boolean isExpired() {
        return expiresTime.toInstant().compareTo(Instant.now()) < 0;
    }

    public void calcExpiresTime() {
        expiresTime = Date.from(LocalDateTime.now().plusMinutes(expires_in).atZone(ZoneId.systemDefault()).toInstant());
    }
}
