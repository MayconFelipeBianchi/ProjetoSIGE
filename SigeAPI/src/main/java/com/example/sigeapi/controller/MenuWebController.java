package com.example.sigeapi.controller;


import org.springframework.web.bind.annotation.GetMapping;

public class MenuWebController {

    @GetMapping("/CadEstacionamento")
    public String CadEstacionamento() {
        return "CadEstacionamento";
    }
    @GetMapping("/CadVagas")
    public String CadVagas() {
        return "Vaga";
    }
    @GetMapping("/CadUsuario")
    public String CadUsuario() {
        return "CadUsuario";
    }
    @GetMapping("/Manutencao")
    public String Manutencao() {
        return "Manutencao";
    }
    @GetMapping("/Acesso")
    public String acessar() {
        return "Login";
    }
}


