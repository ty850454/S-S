package com.dreammakerteam.ss.ssweb.facade.impl;

import com.dreammakerteam.ss.api.dto.UserDTO;
import com.dreammakerteam.ss.api.service.ServiceService;
import com.dreammakerteam.ss.api.service.UserService;
import com.dreammakerteam.ss.api.service.UserServiceService;
import com.dreammakerteam.ss.ssweb.facade.UserFacade;
import com.dreammakerteam.ss.ssweb.wx.WxHelper;
import com.dreammakerteam.ss.ssweb.wx.dto.LoginRes;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserFacadeImpl implements UserFacade {

    private UserService userService;
    private ServiceService serviceService;
    public UserFacadeImpl(UserService userService, ServiceService serviceService) {
        this.userService = userService;
        this.serviceService = serviceService;
    }

    @Override
    public String wxLogin(String code) {

        if (StringUtils.isEmpty(code)) {
            throw new RuntimeException("微信登陆失败");
        }
        LoginRes login = WxHelper.login(code);
        if (login == null || StringUtils.isEmpty(login.getOpenid())) {
            throw new RuntimeException("微信登陆失败");
        }

        Optional<UserDTO> userOptions = userService.getByOpenId(login.getOpenid());
        Long userId;
        if (userOptions.isPresent()) {
            userId = userOptions.get().getId();
        } else {
            userId = userService.insertUserByWxOpenId(login.getOpenid());
            // TODO 临时，给新用户关联服务
            serviceService.addToUsr(193175080393961472L, userId);
            serviceService.addToUsr(193175278847455232L, userId);
            serviceService.addToUsr(193177111145934848L, userId);
            serviceService.addToUsr(193177474456547328L, userId);
            serviceService.addToUsr(193177474859200512L, userId);
        }
        return userId.toString();

    }
}
