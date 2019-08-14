package com.dreammakerteam.ss.ssweb.facade;

import com.dreammakerteam.ss.ssweb.pojo.vo.UserServiceVO;

import java.util.List;

public interface UserServiceFacade {


    List<UserServiceVO> getUserService(Long userId);


    UserServiceVO getUserServiceById(Long id, Long userId);

    void useService(Long id, Long userId);
}
