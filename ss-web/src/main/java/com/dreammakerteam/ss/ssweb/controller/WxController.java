package com.dreammakerteam.ss.ssweb.controller;

import com.dreammakerteam.ss.core.sdk.web.HttpResponse;
import com.dreammakerteam.ss.core.sdk.web.HttpResponseCode;
import com.dreammakerteam.ss.core.dao.entity.UserDO;
import com.dreammakerteam.ss.ssweb.service.impl.dao.impl.repository.WxUserDORepository;
import com.dreammakerteam.ss.ssweb.wx.WxHelper;
import com.dreammakerteam.ss.ssweb.wx.dto.LoginRes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx")
public class WxController {

    private WxUserDORepository wxUserDORepository;
    public WxController(WxUserDORepository wxUserDORepository) {
        this.wxUserDORepository = wxUserDORepository;
    }

    @RequestMapping("/login")
    public HttpResponse login(String code) {
        LoginRes login = WxHelper.login(code);

        if (login == null) {
            return HttpResponse.failure(HttpResponseCode.B_90110);
        }

        UserDO userDO = wxUserDORepository.getByOpenid(login.getOpenid());
        if (userDO == null) {
            userDO = new UserDO();
            userDO.setOpenid(login.getOpenid());
            wxUserDORepository.save(userDO);
        }
        return HttpResponse.success(userDO.getStringId());
    }
}
