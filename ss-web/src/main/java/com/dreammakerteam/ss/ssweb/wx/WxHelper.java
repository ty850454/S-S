package com.dreammakerteam.ss.ssweb.wx;



import com.dreammakerteam.ss.core.sdk.utils.HexUtil;
import com.dreammakerteam.ss.core.sdk.utils.OkHttpUtil;
import com.dreammakerteam.ss.ssweb.wx.dto.AccessToken;
import com.dreammakerteam.ss.ssweb.wx.dto.LoginRes;

import java.util.HashMap;

public class WxHelper {

    private static AccessToken accessToken = null;
    public static LoginRes login(String code) {
        return OkHttpUtil.get("https://api.weixin.qq.com/sns/jscode2session?appid=wxa4ba70f78c429d49&secret=f6244992127a388a1a14ec3ba84d19e2&js_code=" + code + "&grant_type=authorization_code", LoginRes.class);
    }

    public static String getAccessToken() {
        if (accessToken == null || accessToken.isExpired()) {
            System.out.println("获取新的accessToken");
            accessToken = OkHttpUtil.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxa4ba70f78c429d49&secret=f6244992127a388a1a14ec3ba84d19e2", AccessToken.class);
            accessToken.calcExpiresTime();
        }
        System.out.println("accessToken:"+ accessToken.getAccess_token());
        return accessToken.getAccess_token();
    }

    public static String getUnlimited(String scene, String page) {
        // POST https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN
        HashMap<String, String> params = new HashMap<>();
        params.put("access_token", getAccessToken());
        params.put("scene", scene);
        params.put("page", page);
        byte[] bytes = OkHttpUtil.postFormGetBody("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+getAccessToken()+"&scene="+scene+"&page="+page, params);
        return HexUtil.bytes2Hex(bytes);
    }



}
