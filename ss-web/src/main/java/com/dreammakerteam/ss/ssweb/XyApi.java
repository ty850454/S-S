package com.dreammakerteam.ss.ssweb;

import com.dreammakerteam.ss.core.sdk.web.HttpResponse;
import com.dreammakerteam.ss.ssweb.pojo.vo.UserServiceVO;
import feign.RequestLine;

import java.util.List;

public interface XyApi {

    @RequestLine("GET /4")
    UserServiceVO index4();

    @RequestLine("GET /8")
    List<UserServiceVO> index8();
    @RequestLine("GET /10")
    int index10();
    @RequestLine("GET /5")
    void index5();
}
