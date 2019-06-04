package com.dreammakerteam.ss.ssweb.service.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 是否有效枚举
 *
 * @author xy
 */
@Getter
public enum ValidEnum {
    /** 无效 */
    INVALID(0),
    /** 有效 */
    VALID(1),
    ;

    @JsonValue
    private Integer value;

    ValidEnum(Integer value) {
        this.value = value;
    }
}
