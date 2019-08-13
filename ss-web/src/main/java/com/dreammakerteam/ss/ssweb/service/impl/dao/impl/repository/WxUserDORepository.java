package com.dreammakerteam.ss.ssweb.service.impl.dao.impl.repository;

import com.dreammakerteam.ss.core.dao.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WxUserDORepository extends JpaRepository<UserDO, Long> {

    UserDO getByOpenid(String openId);
}
