package com.dreammakerteam.ss.api.pojo.res;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInsertReq {
    private String name;

    private String cover;
    private Integer quantity;
    private String intro;

    private Long userId;

    private Date startDate;

    private Date endDate;

}
