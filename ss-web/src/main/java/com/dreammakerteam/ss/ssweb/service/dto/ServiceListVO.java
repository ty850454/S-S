package com.dreammakerteam.ss.ssweb.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceListVO {
    private Long id;
    private Long userServiceId;
    private String name;
    private Integer quantity;
    private String qrCode;
}
