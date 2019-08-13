package com.dreammakerteam.ss.ssweb.service.dto;

import com.dreammakerteam.ss.core.sdk.serializer.LongIdJsonSerializer;
import com.dreammakerteam.ss.api.enums.ValidEnum;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public abstract class BaseDTO {

    @JsonSerialize(using = LongIdJsonSerializer.class)
    private Long id;

    private Long version;

    private ValidEnum valid;

    private Date createTime;

    private Date updateTime;


    public BaseDTO() {
        valid = ValidEnum.VALID;
    }
}
