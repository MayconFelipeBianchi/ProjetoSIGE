package com.example.sigeapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcessoWebController {

    @GetMapping("/SIGE")
    public String iniciar() {
        return "Acesso";
    }

    @GetMapping("/Acesso")
    public String acessar() {
        return "Login";
    }

    @GetMapping("/CadUsuario")
    public String CadUsuario() {
        return "CadUsuario";
    }
}
