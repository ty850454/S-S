package com.dreammakerteam.ss.ssweb.controller;

import com.dreammakerteam.ss.api.service.UserServiceService;
import com.dreammakerteam.ss.core.sdk.web.HttpResponse;
import com.dreammakerteam.ss.core.sdk.web.HttpResponseCode;
import com.dreammakerteam.ss.ssweb.facade.UserServiceFacade;
import com.dreammakerteam.ss.ssweb.service.dto.ServiceListVO;
import com.dreammakerteam.ss.ssweb.service.dto.UseLogVO;
import com.dreammakerteam.ss.core.dao.entity.ServiceDO;
import com.dreammakerteam.ss.core.dao.entity.ServiceUseLogDO;
import com.dreammakerteam.ss.core.dao.entity.UserServiceDO;
import com.dreammakerteam.ss.ssweb.service.impl.dao.impl.repository.ServiceDORepository;
import com.dreammakerteam.ss.ssweb.service.impl.dao.impl.repository.UseLogDORepository;
import com.dreammakerteam.ss.ssweb.service.impl.dao.impl.repository.UserServiceDORepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
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

    private UserServiceFacade userServiceFacade;
    private UserServiceService userServiceService;
    private UserServiceDORepository userServiceDORepository;
    private ServiceDORepository serviceDORepository;
    private UseLogDORepository useLogDORepository;
    public ServiceController(UserServiceFacade userServiceFacade, UserServiceService userServiceService, UserServiceDORepository userServiceDORepository, ServiceDORepository serviceDORepository, UseLogDORepository useLogDORepository) {
        this.userServiceFacade = userServiceFacade;
        this.userServiceService = userServiceService;
        this.userServiceDORepository = userServiceDORepository;
        this.serviceDORepository = serviceDORepository;
        this.useLogDORepository = useLogDORepository;
    }

    @GetMapping
    public HttpResponse getUserService(@RequestHeader Long userId) {
        return HttpResponse.success(userServiceFacade.getUserService(userId));
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

        ServiceUseLogDO log = new ServiceUseLogDO();
        log.setUserServiceId(one.getId());
        log.setServiceId(one.getServiceId());
        log.setWxUserId(one.getWxUserId());
        useLogDORepository.save(log);
        return HttpResponse.success(null);
    }

    @GetMapping(value = "/logs", params = "use")
    public HttpResponse getLog(Long userId) {
        List<ServiceUseLogDO> byUser = useLogDORepository.getByUserServiceId(userId);
        List<Long> serviceIds = byUser.stream().map(ServiceUseLogDO::getServiceId).collect(Collectors.toList());
        List<ServiceDO> allById = serviceDORepository.findAllById(serviceIds);
        Map<Long, ServiceDO> collect = allById.stream().collect(Collectors.toMap(ServiceDO::getId, o -> o));

        ArrayList<UseLogVO> result = new ArrayList<>();
        for (ServiceUseLogDO serviceUseLogDO : byUser) {
            UseLogVO temp = new UseLogVO();
            ServiceDO serviceDO = collect.get(serviceUseLogDO.getServiceId());

            Instant instant = serviceUseLogDO.getCreateTime().toInstant();
            temp.setDate(LocalDate.from(instant).format(DateTimeFormatter.ISO_DATE));
            temp.setServiceName(serviceDO != null ? serviceDO.getName() : "-");
        }
        return HttpResponse.success(result);
    }

}
