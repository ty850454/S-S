package com.dreammakerteam.ss.ssweb.pojo.vo;


import com.dreammakerteam.ss.api.dto.ServiceDTO;
import com.dreammakerteam.ss.api.dto.ServiceUseLogDTO;
import com.dreammakerteam.ss.api.dto.UserServiceDTO;
import com.dreammakerteam.ss.core.sdk.utils.DateUtil;
import com.dreammakerteam.ss.ssweb.config.LongIdJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
        vo.setUseLog(serviceUseLogs.stream().map(o -> DateUtil.DATE.format(o.getCreateTime()) + "在" + o.getServiceName() + "处使用").collect(Collectors.toList()));
        return vo;
    }

}
