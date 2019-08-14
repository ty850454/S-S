package com.dreammakerteam.ss.core.impl;

import com.dreammakerteam.ss.api.dto.ServiceDTO;
import com.dreammakerteam.ss.api.service.ServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 服务实现
 *
 * @author xuyang
 */
@Slf4j
@Service
public class ServiceServiceImpl implements ServiceService {

    @Override
    public Optional<ServiceDTO> getById(Long id) {
        // TODO
        return Optional.empty();
    }

    @Override
    public List<ServiceDTO> listByIds(List<Long> ids) {
        // TODO
        return null;
    }
}
