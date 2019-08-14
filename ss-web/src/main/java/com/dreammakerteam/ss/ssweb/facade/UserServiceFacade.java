package com.dreammakerteam.ss.ssweb.facade;

import com.dreammakerteam.ss.ssweb.pojo.UserServiceVO;

import java.util.List;

public interface UserServiceFacade {


    List<UserServiceVO> getUserService(Long userId);

}
