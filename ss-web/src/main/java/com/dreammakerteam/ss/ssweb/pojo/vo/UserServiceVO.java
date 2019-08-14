package com.dreammakerteam.ss.ssweb.pojo.vo;


import com.dreammakerteam.ss.api.dto.ServiceDTO;
import com.dreammakerteam.ss.api.dto.ServiceUseLogDTO;
import com.dreammakerteam.ss.api.dto.UserServiceDTO;
import com.dreammakerteam.ss.ssweb.config.LongIdJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
public class UserServiceVO {

    @JsonSerialize(using = LongIdJsonSerializer.class)
    private Long id;

    private String intro;

    private String serviceName;

    private Integer quantity;

    private Date endDate;

    private List<String> useLog;



    public static UserServiceVO by(UserServiceDTO userService, ServiceDTO service) {
        return UserServiceVO.builder()
                .id(userService.getId())
                .quantity(userService.getQuantity())
                .intro(service != null ?service.getIntro() : null)
                .endDate(userService.getEndDate())
                .serviceName(service != null ? service.getName() : null)
                .build();
    }

    public static UserServiceVO by(UserServiceDTO userService, ServiceDTO service, List<ServiceUseLogDTO> serviceUseLogs) {
        UserServiceVO vo = by(userService, service);
//        vo.setUseLog(serviceUseLogs.stream().);

        return vo;
    }

}
