package com.example.sigeapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadEstacionamentoWebController {
    @GetMapping("/CadEstacionamento")
    public String CadEstacionamento() {
        return "CadEstacionamento";
    }
}