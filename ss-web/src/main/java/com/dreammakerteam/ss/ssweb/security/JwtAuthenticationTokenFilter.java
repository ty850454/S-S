/*
package com.dreammakerteam.ss.ssweb.sdk;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

*/
/**
 * 此过滤器主要是验证令牌的合法性，如果令牌合法，则获取用户信息，并且存入
 * @author sy
 *//*

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = request.getHeader("token");
        String secret = "eyJleHAiOjE1NDMyMDUyODUsInN1YiI6ImFkbWluIiwiY3Jl";
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        System.out.println(body);
        System.out.println(body.getSubject());
        chain.doFilter(request, response);
    }
}
*/
