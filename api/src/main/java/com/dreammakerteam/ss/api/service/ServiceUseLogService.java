package com.dreammakerteam.ss.api.service;

import com.dreammakerteam.ss.api.dto.ServiceUseLogDTO;

import java.util.List;


public interface ServiceUseLogService {

    List<ServiceUseLogDTO> listByUserServiceId(Long userServiceId);

}
