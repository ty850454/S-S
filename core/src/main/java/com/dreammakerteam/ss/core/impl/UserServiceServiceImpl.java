package com.dreammakerteam.ss.core.impl;

import com.dreammakerteam.ss.api.dto.UserServiceDTO;
import com.dreammakerteam.ss.api.service.UserServiceService;
import com.dreammakerteam.ss.core.dao.api.ServiceRepository;
import com.dreammakerteam.ss.core.dao.api.UserServiceRepository;
import com.dreammakerteam.ss.core.dao.entity.ServiceDO;
import com.dreammakerteam.ss.core.dao.entity.UserServiceDO;
import com.dreammakerteam.ss.core.sdk.utils.DtoUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceServiceImpl implements UserServiceService {

    private UserServiceRepository userServiceRepository;
    public UserServiceServiceImpl(UserServiceRepository userServiceRepository) {
        this.userServiceRepository = userServiceRepository;
    }

    @Override
    public Optional<UserServiceDTO> getById(Long id) {
        return userServiceRepository.findById(id).map(o -> DtoUtil.copyProperties(o, UserServiceDTO.class));
    }

    @Override
    public List<UserServiceDTO> listByUserId(Long userId) {
        return userServiceRepository.findByUserId(userId).stream().map(o ->DtoUtil.copyProperties(o, UserServiceDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserServiceDTO> listByIds(List<Long> ids) {
        // TODO
        return null;
    }
}
