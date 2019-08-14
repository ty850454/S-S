package com.dreammakerteam.ss.core.dao.api;

import com.dreammakerteam.ss.core.dao.entity.ServiceDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceDO, Long> {


    /**
     * 获取用户创建的所有服务
     *
     * @param userId 用户id
     * @return 服务列表
     */
    List<ServiceDO> findByUserId(Long userId);



}
