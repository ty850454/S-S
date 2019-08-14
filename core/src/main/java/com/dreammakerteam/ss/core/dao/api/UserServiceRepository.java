package com.dreammakerteam.ss.core.dao.api;

import com.dreammakerteam.ss.core.dao.entity.UserServiceDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserServiceRepository extends JpaRepository<UserServiceDO, Long> {

    List<UserServiceDO> findByUserId(Long userId);
}
