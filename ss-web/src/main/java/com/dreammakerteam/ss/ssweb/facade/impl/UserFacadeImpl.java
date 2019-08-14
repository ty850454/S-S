package com.dreammakerteam.ss.ssweb.facade.impl;

import com.dreammakerteam.ss.api.dto.UserDTO;
import com.dreammakerteam.ss.api.service.UserService;
import com.dreammakerteam.ss.ssweb.facade.UserFacade;
import com.dreammakerteam.ss.ssweb.wx.WxHelper;
import com.dreammakerteam.ss.ssweb.wx.dto.LoginRes;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserFacadeImpl implements UserFacade {

    private UserService userService;
    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
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
        return userOptions.map(userDTO -> userDTO.getId().toString()).orElseGet(() -> userService.insertUserByWxOpenId(login.getOpenid()).toString());

    }
}
