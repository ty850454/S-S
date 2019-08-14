package com.dreammakerteam.ss.api.service;

import com.dreammakerteam.ss.api.dto.ServiceDTO;

import java.util.List;
import java.util.Optional;

/**
 * 服务
 *
 * @author xy
 */
public interface ServiceService {


    /**
     * 通过id获取服务
     *
     * @param id 服务id
     * @return 服务
     */
    Optional<ServiceDTO> getById(Long id);


    /**
     * 批量获取服务
     *
     * @param ids 用户id
     * @return 服务
     */
    List<ServiceDTO> listByIds(List<Long> ids);



}
