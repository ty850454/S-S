package com.dreammakerteam.ss.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 用户服务卡
 *
 * @author xy
 */
@Getter
@Setter
@ToString
public class UserServiceDTO extends BaseDTO {

    private Long userId;

    private Long serviceId;

    private Integer quantity;

    private Date startDate;

    private Date endDate;
}
