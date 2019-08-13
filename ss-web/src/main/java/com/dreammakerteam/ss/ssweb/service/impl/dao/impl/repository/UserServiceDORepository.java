package com.dreammakerteam.ss.ssweb.service.impl.dao.impl.repository;

import com.dreammakerteam.ss.ssweb.service.impl.dao.entity.UserServiceDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserServiceDORepository extends JpaRepository<UserServiceDO, Long> {

    List<UserServiceDO> getByWxUserId(Long wxUserId);

    UserServiceDO getByServiceIdAndWxUserId(Long serviceId, Long wxUserId);
}
