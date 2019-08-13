package com.dreammakerteam.ss.ssweb.service.impl.dao.impl.repository;

import com.dreammakerteam.ss.ssweb.service.impl.dao.entity.UseLogDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UseLogDORepository extends JpaRepository<UseLogDO, Long> {

    List<UseLogDO> getByUserServiceId(Long userServiceId);

}
