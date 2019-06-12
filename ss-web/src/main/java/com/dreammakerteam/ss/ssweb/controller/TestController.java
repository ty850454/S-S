package com.dreammakerteam.ss.ssweb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private static String temp = null;
    @GetMapping("/getInfo")
    public String getInfo() {
        return temp;
    }

    @GetMapping("/setInfo")
    public String setInfo(String info) {
        return temp = info;
    }

}
