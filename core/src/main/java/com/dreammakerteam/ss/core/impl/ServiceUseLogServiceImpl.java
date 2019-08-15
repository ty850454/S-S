package com.dreammakerteam.ss.core.impl;

import com.dreammakerteam.ss.api.dto.ServiceUseLogDTO;
import com.dreammakerteam.ss.api.service.ServiceUseLogService;
import com.dreammakerteam.ss.core.dao.api.ServiceRepository;
import com.dreammakerteam.ss.core.dao.api.ServiceUseLogRepository;
import com.dreammakerteam.ss.core.dao.api.UserRepository;
import com.dreammakerteam.ss.core.dao.entity.ServiceDO;
import com.dreammakerteam.ss.core.dao.entity.UserDO;
import com.dreammakerteam.ss.core.sdk.utils.DtoUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ServiceUseLogServiceImpl implements ServiceUseLogService {

    private ServiceUseLogRepository serviceUseLogRepository;
    private UserRepository userRepository;
    private ServiceRepository serviceRepository;
    public ServiceUseLogServiceImpl(ServiceUseLogRepository serviceUseLogRepository, UserRepository userRepository, ServiceRepository serviceRepository) {
        this.serviceUseLogRepository = serviceUseLogRepository;
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<ServiceUseLogDTO> listByUserServiceId(Long userServiceId) {
        List<ServiceUseLogDTO> serviceUseLogDTOS = DtoUtil.copyPropertiesList(serviceUseLogRepository.findByUserServiceId(userServiceId), ServiceUseLogDTO.class);
        List<Long> serviceIds = serviceUseLogDTOS.stream().map(ServiceUseLogDTO::getServiceId).collect(Collectors.toList());
        List<Long> userIds = serviceUseLogDTOS.stream().map(ServiceUseLogDTO::getUserId).collect(Collectors.toList());
        Map<Long, UserDO> userMap = userRepository.findAllById(userIds).stream().collect(Collectors.toMap(UserDO::getId, o -> o));
        Map<Long, ServiceDO> serviceMap = serviceRepository.findAllById(serviceIds).stream().collect(Collectors.toMap(ServiceDO::getId, o -> o));
        for (ServiceUseLogDTO dto : serviceUseLogDTOS) {
            UserDO userDO = userMap.get(dto.getUserId());
            ServiceDO serviceDO = serviceMap.get(dto.getServiceId());
            dto.setServiceName(serviceDO != null ? serviceDO.getName() : null);
            dto.setUserNickname(userDO != null ? userDO.getNickname() : null);
        }

        return serviceUseLogDTOS;
    }
}
