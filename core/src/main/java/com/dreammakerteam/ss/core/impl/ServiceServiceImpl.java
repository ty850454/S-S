package com.dreammakerteam.ss.core.impl;

import com.dreammakerteam.ss.api.dto.ServiceDTO;
import com.dreammakerteam.ss.api.pojo.res.ServiceInsertReq;
import com.dreammakerteam.ss.api.service.ServiceService;
import com.dreammakerteam.ss.core.dao.api.ServiceRepository;
import com.dreammakerteam.ss.core.dao.api.UserServiceRepository;
import com.dreammakerteam.ss.core.dao.entity.ServiceDO;
import com.dreammakerteam.ss.core.dao.entity.UserServiceDO;
import com.dreammakerteam.ss.core.sdk.utils.DtoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 服务实现
 *
 * @author xuyang
 */
@Slf4j
@Service
public class ServiceServiceImpl implements ServiceService {

    private ServiceRepository serviceRepository;
    private UserServiceRepository userServiceRepository;
    public ServiceServiceImpl(ServiceRepository serviceRepository, UserServiceRepository userServiceRepository) {
        this.serviceRepository = serviceRepository;
        this.userServiceRepository = userServiceRepository;
    }
    @Override
    public Long insertService(ServiceInsertReq req) {
        return serviceRepository.save(ServiceDO.builder()
                .name(req.getName())
                .quantity(req.getQuantity())
                .cover(req.getCover())
                .intro(req.getIntro())
                .userId(req.getUserId())
                .startDate(req.getStartDate())
                .build()).getId();
    }

    @Override
    public Optional<ServiceDTO> getById(Long id) {
        return serviceRepository.findById(id).map(o -> DtoUtil.copyProperties(o, ServiceDTO.class));
    }

    @Override
    public List<ServiceDTO> listByIds(List<Long> ids) {
        return serviceRepository.findAllById(ids).stream().map(o -> DtoUtil.copyProperties(o, ServiceDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void addToUsr(Long serviceId, Long userId) {
        ServiceDO service = serviceRepository.findById(serviceId).orElseThrow(() -> new RuntimeException("服务不存在"));
        UserServiceDO userService = UserServiceDO.builder()
                .userId(userId)
                .serviceId(serviceId)
                .quantity(service.getQuantity())
                .startDate(new Date())
                .endDate(service.getEndDate())
                .build();
        // TODO 没有判断服务是否到期
        userServiceRepository.save(userService);

    }

}
