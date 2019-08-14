package com.dreammakerteam.ss.api.service;

import com.dreammakerteam.ss.api.dto.UserDTO;

import java.util.Optional;

public interface UserService {


    Optional<UserDTO> getById(Long userId);

    Optional<UserDTO> getByOpenId(String openId);

    Long insertUserByWxOpenId(String openId);

}
