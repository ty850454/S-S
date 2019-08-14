package com.dreammakerteam.ss.api.service;

import com.dreammakerteam.ss.api.dto.UserServiceDTO;

import java.util.List;
import java.util.Optional;

/**
 * 用户服务卡
 *
 * @author xy
 */
public interface UserServiceService {

    /**
     * 通过id获取服务卡
     *
     * @param id 服务卡id
     * @return 服务卡
     */
    Optional<UserServiceDTO> getById(Long id);

    /**
     * 获取用户所有服务卡
     *
     * @param userId 用户id
     * @return 服务
     */
    List<UserServiceDTO> listByUserId(Long userId);


    /**
     * 批量获取服务卡
     *
     * @param ids 服务卡id
     * @return 服务卡
     */
    List<UserServiceDTO> listByIds(List<Long> ids);



}
