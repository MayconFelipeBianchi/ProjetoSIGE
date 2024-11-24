package com.example.sigeapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class VagaWebController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/CadVagas")
    public String CadVagas() {
        return "Vaga";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/VoltarMenu2")
    public String voltarAcesso() {
        return "Menu";
    }
}
