package com.dreammakerteam.ss.ssweb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping
    public String getInfo() {
        return "asdasdasd";
    }


    public String setInfo() {
        return "";
    }


}
