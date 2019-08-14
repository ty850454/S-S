package com.dreammakerteam.ss.ssweb.pojo;


import com.dreammakerteam.ss.api.dto.ServiceDTO;
import com.dreammakerteam.ss.api.dto.UserServiceDTO;
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

    private Long id;

    private String serviceName;

    private Integer quantity;

    private Date endDate;

    private List<String> useLog;



    public static UserServiceVO by(UserServiceDTO userService, ServiceDTO service) {
        return UserServiceVO.builder()
                .id(userService.getId())
                .quantity(userService.getQuantity())
                .endDate(userService.getEndDate())
//                .useLog() // TODO
                .serviceName(service != null ? service.getName() : null)
                .build();
    }

}
