package com.dreammakerteam.ss.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 服务记录
 *
 * @author xy
 */
@Getter
@Setter
@ToString
public class ServiceUseLogDTO extends BaseDTO {

    private Long userServiceId;

    private Long serviceId;
    private String serviceName;

    private Long userId;
    private String userNickname;
}
