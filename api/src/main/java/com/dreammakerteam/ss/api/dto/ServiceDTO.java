package com.dreammakerteam.ss.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 服务
 *
 * @author xy
 */
@Setter
@Getter
@ToString
public class ServiceDTO extends BaseDTO {

    private String name;
    private String cover;
    private Integer quantity;
    private String intro;
    private Long userId;
    private Date startDate;
    private Date endDate;
}
