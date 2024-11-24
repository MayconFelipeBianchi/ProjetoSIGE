package com.example.sigeapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManutencaoWebController {
    @GetMapping("/Manutencao")
    public String Manutencao() {
        return "Manutencao";
    }


    @GetMapping("/VoltarManutencao")
    public String voltarAcesso() {
        return "Menu";
    }
}
