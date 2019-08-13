package com.dreammakerteam.ss.ssweb.service.impl.dao.impl.repository;

import com.dreammakerteam.ss.core.dao.entity.ServiceUseLogDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UseLogDORepository extends JpaRepository<ServiceUseLogDO, Long> {

    List<ServiceUseLogDO> getByUserServiceId(Long userServiceId);

}
