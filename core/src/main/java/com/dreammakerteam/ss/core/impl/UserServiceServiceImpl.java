package com.dreammakerteam.ss.core.impl;

import com.dreammakerteam.ss.api.dto.UserServiceDTO;
import com.dreammakerteam.ss.api.service.UserServiceService;
import com.dreammakerteam.ss.core.dao.api.ServiceRepository;
import com.dreammakerteam.ss.core.dao.api.UserServiceRepository;
import com.dreammakerteam.ss.core.dao.entity.ServiceDO;
import com.dreammakerteam.ss.core.dao.entity.UserServiceDO;
import com.dreammakerteam.ss.core.sdk.utils.DtoUtil;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceServiceImpl implements UserServiceService {

    private UserServiceRepository userServiceRepository;
    private ServiceRepository serviceRepository;
    public UserServiceServiceImpl(UserServiceRepository userServiceRepository, ServiceRepository serviceRepository) {
        this.userServiceRepository = userServiceRepository;
        this.serviceRepository = serviceRepository;
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

    @Override
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Transactional(rollbackFor = Exception.class)
    public void use(Long id, Long userId) {
        UserServiceDO userService = userServiceRepository.findById(id).orElseThrow(() -> new RuntimeException("服务不存在"));

        ServiceDO service = serviceRepository.findById(userService.getServiceId()).orElseThrow(() -> new RuntimeException("服务不存在"));
        if (!service.getUserId().equals(userId)) {
            throw new RuntimeException("这张卡不是您发放的，只可以扫描自己使用的卡片");
        }
        // TODO 存在并发问题

        Integer quantity = userService.getQuantity();
        if (quantity <= 0) {
            throw new RuntimeException("剩余服务次数不足，无法使用");
        }
        // TODO 过期检查

        userService.setQuantity(quantity - 1);
        userServiceRepository.save(userService);
    }
}
