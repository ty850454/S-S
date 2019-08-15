package com.dreammakerteam.ss.core.dao.api;

import com.dreammakerteam.ss.core.dao.entity.SystemMsgDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemMsgRepository extends JpaRepository<SystemMsgDO, Long> {

    Long countByUserIdAndUnreadFalse(Long userId);

    List<SystemMsgDO> findByUserIdOrderByUnread(Long userId);

}
