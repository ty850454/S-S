package com.dreammakerteam.ss.core.impl;

import com.dreammakerteam.ss.api.dto.ServiceUseLogDTO;
import com.dreammakerteam.ss.api.service.ServiceUseLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUseLogServiceImpl implements ServiceUseLogService {
    @Override
    public List<ServiceUseLogDTO> listByUserServiceId(Long userServiceId) {
        // TODO
        return null;
    }
}
