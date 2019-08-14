package com.dreammakerteam.ss.core.impl;

import com.dreammakerteam.ss.api.dto.UserDTO;
import com.dreammakerteam.ss.api.service.UserService;
import com.dreammakerteam.ss.core.dao.api.UserRepository;
import com.dreammakerteam.ss.core.dao.entity.UserDO;
import com.dreammakerteam.ss.core.sdk.utils.DtoUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDTO> getById(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> getByOpenId(String openId) {
        Optional<UserDO> user = userRepository.getByOpenId(openId);
        return user.map(userDO -> DtoUtil.copyProperties(userDO, UserDTO.class));
    }

    @Override
    @Transactional
    public Long insertUserByWxOpenId(String openId) {
        UserDO save = userRepository.save(UserDO.builder().headPortrait("无").nickname("微信用户").openId(openId).build());
        if (save == null || save.getId() == null) {
            throw new RuntimeException("登陆失败");
        }
        return save.getId();
    }
}
