package com.dreammakerteam.ss.ssweb;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

public class MyTest {


    @Test
    public void jwt() {
        String secret = "eyJleHAiOjE1NDMyMDUyODUsInN1YiI6ImFkbWluIiwiY3Jl";
        Claims claims = new DefaultClaims();
        claims.setSubject("asdadwdwadawdwa");
        HashMap<String, Object> map = new HashMap<>();
        map.put("1", "2");
        String token = Jwts.builder().setClaims(claims).setExpiration(new Date(System.currentTimeMillis() + 3600000)).signWith(SignatureAlgorithm.HS512, secret).compact();
        System.out.println(token);


        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        System.out.println(body);
        System.out.println(body.getSubject());
    }
}
