package com.dreammakerteam.ss.ssweb.controller;

import com.dreammakerteam.ss.core.sdk.web.HttpResponse;
import com.dreammakerteam.ss.ssweb.facade.UserFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx")
public class WxController {

    private UserFacade userFacade;
    public WxController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @RequestMapping("/login")
    public HttpResponse login(String code) {
        return HttpResponse.success(userFacade.wxLogin(code));
    }
}
