package com.dreammakerteam.ss.api.enums;

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

    private int value;

    ValidEnum(int value) {
        this.value = value;
    }
}
