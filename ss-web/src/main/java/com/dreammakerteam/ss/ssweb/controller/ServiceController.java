package com.dreammakerteam.ss.ssweb.controller;

import com.dreammakerteam.ss.core.sdk.web.HttpResponse;
import com.dreammakerteam.ss.ssweb.facade.UserServiceFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private UserServiceFacade userServiceFacade;
    public ServiceController(UserServiceFacade userServiceFacade) {
        this.userServiceFacade = userServiceFacade;
    }

    @GetMapping
    public HttpResponse getUserService(@RequestHeader Long userId) {
        return HttpResponse.success(userServiceFacade.getUserService(userId));
    }

    @GetMapping("/{id}")
    public HttpResponse getUserServiceById(@RequestHeader Long userId, @PathVariable Long id) {
        return HttpResponse.success(userServiceFacade.getUserServiceById(id, userId));
    }

    @GetMapping(value = "/{id}", params = "use")
    public HttpResponse useService(@RequestHeader Long userId, @PathVariable Long id) {
        userServiceFacade.useService(id, userId);
        return HttpResponse.success();
    }

}
