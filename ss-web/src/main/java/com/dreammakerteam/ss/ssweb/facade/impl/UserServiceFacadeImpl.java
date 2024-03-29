package com.dreammakerteam.ss.ssweb.facade.impl;

import com.dreammakerteam.ss.api.dto.ServiceDTO;
import com.dreammakerteam.ss.api.dto.ServiceUseLogDTO;
import com.dreammakerteam.ss.api.dto.UserServiceDTO;
import com.dreammakerteam.ss.api.service.ServiceService;
import com.dreammakerteam.ss.api.service.ServiceUseLogService;
import com.dreammakerteam.ss.api.service.UserServiceService;
import com.dreammakerteam.ss.ssweb.facade.UserServiceFacade;
import com.dreammakerteam.ss.ssweb.pojo.vo.UserServiceVO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceFacadeImpl implements UserServiceFacade {

    private UserServiceService userServiceService;
    private ServiceUseLogService serviceUseLogService;
    private ServiceService serviceService;
    public UserServiceFacadeImpl(UserServiceService userServiceService, ServiceUseLogService serviceUseLogService, ServiceService serviceService) {
        this.userServiceService = userServiceService;
        this.serviceUseLogService = serviceUseLogService;
        this.serviceService = serviceService;
    }

    @Override
    public List<UserServiceVO> getUserService(Long userId) {

        List<UserServiceDTO> userServices = userServiceService.listByUserId(userId);
        if (CollectionUtils.isEmpty(userServices)) {
            return Collections.emptyList();
        }
        List<Long> serviceIds = userServices.stream().map(UserServiceDTO::getServiceId).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(serviceIds)) {
            return Collections.emptyList();
        }
        List<ServiceDTO> services = serviceService.listByIds(serviceIds);
        Map<Long, ServiceDTO> serviceMap;
        if (CollectionUtils.isEmpty(services)) {
            serviceMap = Collections.emptyMap();
        } else {
            serviceMap = services.stream().collect(Collectors.toMap(ServiceDTO::getId, o -> o));
        }

        return userServices.stream().map(dto -> UserServiceVO.by(dto, serviceMap.get(dto.getServiceId()))).collect(Collectors.toList());
    }

    @Override
    public UserServiceVO getUserServiceById(Long id, Long userId) {
        //TODO
        UserServiceDTO userService = userServiceService.getById(id).orElseThrow(() -> new RuntimeException("服务不存在"));
        ServiceDTO service = serviceService.getById(userService.getServiceId()).orElseThrow(() -> new RuntimeException("服务不存在"));
        List<ServiceUseLogDTO> serviceUseLogs = serviceUseLogService.listByUserServiceId(service.getId());
        return UserServiceVO.by(userService, service, serviceUseLogs);
    }


    @Override
    public void useService(Long id, Long userId) {
        userServiceService.use(id, userId);
    }
}
