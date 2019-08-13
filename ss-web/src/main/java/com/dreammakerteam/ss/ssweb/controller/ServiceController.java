package com.dreammakerteam.ss.ssweb.controller;

import com.dreammakerteam.ss.ssweb.sdk.web.HttpResponse;
import com.dreammakerteam.ss.ssweb.sdk.web.HttpResponseCode;
import com.dreammakerteam.ss.ssweb.service.dto.ServiceListVO;
import com.dreammakerteam.ss.ssweb.service.dto.UseLogVO;
import com.dreammakerteam.ss.ssweb.service.impl.dao.entity.ServiceDO;
import com.dreammakerteam.ss.ssweb.service.impl.dao.entity.UseLogDO;
import com.dreammakerteam.ss.ssweb.service.impl.dao.entity.UserServiceDO;
import com.dreammakerteam.ss.ssweb.service.impl.dao.impl.repository.ServiceDORepository;
import com.dreammakerteam.ss.ssweb.service.impl.dao.impl.repository.UseLogDORepository;
import com.dreammakerteam.ss.ssweb.service.impl.dao.impl.repository.UserServiceDORepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private UserServiceDORepository userServiceDORepository;
    private ServiceDORepository serviceDORepository;
    private UseLogDORepository useLogDORepository;
    public ServiceController(UserServiceDORepository userServiceDORepository, ServiceDORepository serviceDORepository, UseLogDORepository useLogDORepository) {
        this.userServiceDORepository = userServiceDORepository;
        this.serviceDORepository = serviceDORepository;
        this.useLogDORepository = useLogDORepository;
    }

    @GetMapping
    public HttpResponse getUserService(Long userId) {
        List<UserServiceDO> byWxUserId = userServiceDORepository.getByWxUserId(userId);

        List<Long> serviceIds = byWxUserId.stream().map(UserServiceDO::getServiceId).collect(Collectors.toList());
        List<ServiceDO> allById = serviceDORepository.findAllById(serviceIds);
        Map<Long, ServiceDO> collect = allById.stream().collect(Collectors.toMap(ServiceDO::getId, o -> o));

        ArrayList<ServiceListVO> result = new ArrayList<>();
        for (UserServiceDO userServiceDO : byWxUserId) {
            ServiceListVO serviceListVO = new ServiceListVO();
            result.add(serviceListVO);
            ServiceDO serviceDO = collect.get(userServiceDO.getServiceId());
            serviceListVO.setName(serviceDO != null ? serviceDO.getName() : "服务已下架");
            serviceListVO.setId(serviceDO.getId());
            serviceListVO.setUserServiceId(userServiceDO.getId());
            serviceListVO.setQuantity(userServiceDO.getQuantity());
        }

        return HttpResponse.success(result);
    }
    @GetMapping("/{id}")
    public HttpResponse geServiceById(@PathVariable Long id, Long userId) {
        UserServiceDO one1 = userServiceDORepository.findById(id).orElse(null);
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
        return HttpResponse.success(serviceListVO);
    }

    @GetMapping(value = "/useService/{id}")
    @Transactional
    public HttpResponse useService(@PathVariable Long id) {
        UserServiceDO one = userServiceDORepository.findById(id).orElse(null);

        if (one == null) {
            return HttpResponse.failure(HttpResponseCode.A_90011);
        }
        if (one.getQuantity() <= 0) {
            return HttpResponse.failure(HttpResponseCode.A_90012);
        }
        one.setQuantity(one.getQuantity() - 1);
        userServiceDORepository.save(one);

        UseLogDO log = new UseLogDO();
        log.setUserServiceId(one.getId());
        log.setServiceId(one.getServiceId());
        log.setWxUserId(one.getWxUserId());
        useLogDORepository.save(log);
        return HttpResponse.success(null);
    }

    @GetMapping(value = "/logs", params = "use")
    public HttpResponse getLog(Long userId) {
        List<UseLogDO> byUser = useLogDORepository.getByUserServiceId(userId);
        List<Long> serviceIds = byUser.stream().map(UseLogDO::getServiceId).collect(Collectors.toList());
        List<ServiceDO> allById = serviceDORepository.findAllById(serviceIds);
        Map<Long, ServiceDO> collect = allById.stream().collect(Collectors.toMap(ServiceDO::getId, o -> o));

        ArrayList<UseLogVO> result = new ArrayList<>();
        for (UseLogDO useLogDO : byUser) {
            UseLogVO temp = new UseLogVO();
            ServiceDO serviceDO = collect.get(useLogDO.getServiceId());

            Instant instant = useLogDO.getCreateTime().toInstant();
            temp.setDate(LocalDate.from(instant).format(DateTimeFormatter.ISO_DATE));
            temp.setServiceName(serviceDO != null ? serviceDO.getName() : "-");
        }
        return HttpResponse.success(result);
    }

}
