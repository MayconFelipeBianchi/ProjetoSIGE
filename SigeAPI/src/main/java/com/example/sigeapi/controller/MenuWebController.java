package com.example.sigeapi.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MenuWebController {

    @GetMapping("/Menu")
    public String Menu() {
        return "Menu";
    }

}
