package com.dreammakerteam.ss.core.dao.api;

import com.dreammakerteam.ss.core.dao.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDO, Long> {

    /**
     * 通过微信openId获取用户
     *
     * @param openId 微信openId
     * @return 用户
     */
    Optional<UserDO> getByOpenId(String openId);


    
}
