package com.dreammakerteam.ss.ssweb.service.impl.dao.impl.repository;

import com.dreammakerteam.ss.ssweb.service.impl.dao.entity.WxUserDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WxUserDORepository extends JpaRepository<WxUserDO, Long> {

    WxUserDO getByOpenid(String openId);
}
