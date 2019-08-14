package com.dreammakerteam.ss.api.dto;

import com.dreammakerteam.ss.api.enums.ValidEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class BaseDTO {

    private Long id;

    private Long version;

    private ValidEnum valid;

    private Date createTime;

    private Date updateTime;

    public String getStringId() {
        return id != null ? id.toString() : null;
    }




}
