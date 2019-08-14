package com.dreammakerteam.ss.core.dao.api;

import com.dreammakerteam.ss.core.dao.entity.ServiceUseLogDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceUseRepository extends JpaRepository<ServiceUseLogDO, Long> {

    /**
     * 获取用户服务卡的使用记录
     *
     * @param userServiceId 用户服务卡id
     * @return 使用记录
     */
    List<ServiceUseLogDO> findByUserServiceId(Long userServiceId);

    /**
     * 获取服务的使用记录
     *
     * @param serviceId 用户服务卡id
     * @return 使用记录
     */
    List<ServiceUseLogDO> findByServiceId(Long serviceId);

    /**
     * 获取用户的使用记录
     *
     * @param userId 用户id
     * @return 使用记录
     */
    List<ServiceUseLogDO> findByUserId(Long userId);

}
