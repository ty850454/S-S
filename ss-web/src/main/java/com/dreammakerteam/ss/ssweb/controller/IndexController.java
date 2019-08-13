package com.dreammakerteam.ss.ssweb.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping
public class IndexController {



    @GetMapping
    public List<Serializable> index() {
        return Arrays.asList('1', "2");
    }

    @GetMapping("/2")
    public Object index2() {
        return "2";
    }


}
