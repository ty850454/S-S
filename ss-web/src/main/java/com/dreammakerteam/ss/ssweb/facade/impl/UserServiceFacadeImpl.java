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


     /*   UserServiceDO one1 = userServiceDORepository.findById(id).orElse(null);
        if (one1 == null) {
            return HttpResponse.failure(HttpResponseCode.A_90010);
        }
        ServiceDO one = serviceDORepository.findById(one1.getServiceId()).orElse(null);
        if (one == null) {
            return HttpResponse.failure(HttpResponseCode.A_90010);
        }

        ServiceListVO serviceListVO = new ServiceListVO();
        serviceListVO.setName(one.getName());
        serviceListVO.setId(one.getId());
        serviceListVO.setQuantity(one1.getQuantity());
        serviceListVO.setUserServiceId(one1.getId());
//        serviceListVO.setQrCode(WxHelper.getUnlimited("" + one1.getId(), "pages/scan/scan"));
        return HttpResponse.success(serviceListVO);*/
        return UserServiceVO.by(userService, service);
    }


    @Override
    public void useService(Long id, Long userId) {



/*
        UserServiceDO one = userServiceDORepository.findById(id).orElse(null);

        if (one == null) {
            return HttpResponse.failure(HttpResponseCode.A_90011);
        }
        if (one.getQuantity() <= 0) {
            return HttpResponse.failure(HttpResponseCode.A_90012);
        }
        one.setQuantity(one.getQuantity() - 1);
        userServiceDORepository.save(one);

        ServiceUseLogDO log = new ServiceUseLogDO();
        log.setUserServiceId(one.getId());
        log.setServiceId(one.getServiceId());
        log.setWxUserId(one.getWxUserId());
        useLogDORepository.save(log);
        return HttpResponse.success(null);*/
    }
}
