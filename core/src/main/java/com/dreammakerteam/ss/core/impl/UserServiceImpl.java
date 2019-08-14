package com.dreammakerteam.ss.core.impl;

import com.dreammakerteam.ss.api.dto.UserDTO;
import com.dreammakerteam.ss.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Optional<UserDTO> getById(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> getByOpenId(String openId) {
        // TODO
        return Optional.empty();
    }

    @Override
    public Long insertUserByWxOpenId(String openId) {
        // TODO
        return null;
    }
}
