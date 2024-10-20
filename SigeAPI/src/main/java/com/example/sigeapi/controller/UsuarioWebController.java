package com.example.sigeapi.controller;

import com.example.sigeapi.model.UsuarioWeb;
import com.example.sigeapi.service.UsuarioWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios/web")
public class UsuarioWebController {

    @Autowired
    private UsuarioWebService usuarioWebService;

    @PostMapping
    public ResponseEntity<UsuarioWeb> cadastrarUsuario(@RequestBody UsuarioWeb usuario) {
        UsuarioWeb novoUsuario = usuarioWebService.save(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioWeb>> listarUsuarios() {
        List<UsuarioWeb> usuarios = usuarioWebService.getAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioWeb> login(@RequestBody UsuarioWeb usuario) {
        UsuarioWeb usuarioLogado = usuarioWebService.login(usuario);
        if (usuarioLogado != null) {
            return new ResponseEntity<>(usuarioLogado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
