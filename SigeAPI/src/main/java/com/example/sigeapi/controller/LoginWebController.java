package com.example.sigeapi.controller;

import com.example.sigeapi.model.UsuarioWeb;
import com.example.sigeapi.service.UsuarioWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginWebController {

    @Autowired
    private UsuarioWebService usuarioWebService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioWeb> login(@RequestBody UsuarioWeb usuario) {
        UsuarioWeb usuarioLogado = usuarioWebService.login(usuario);

        if (usuarioLogado != null) {
            return ResponseEntity.ok(usuarioLogado);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/AcessoMenu")
    public String abrirMenu() {
        return "Menu";
    }

    @GetMapping("/Voltar")
    public String voltarAcesso() {
        return "Acesso";
    }
}
