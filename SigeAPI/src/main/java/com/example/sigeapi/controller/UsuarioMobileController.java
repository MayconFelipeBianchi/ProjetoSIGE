package com.example.sigeapi.controller;

import com.example.sigeapi.model.UsuarioMobile;
import com.example.sigeapi.service.UsuarioMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios/mobile")
public class UsuarioMobileController {

    @Autowired
    private UsuarioMobileService usuarioMobileService;

    @PostMapping
    public ResponseEntity<UsuarioMobile> cadastrarUsuario(@RequestBody UsuarioMobile usuario) {
        UsuarioMobile novoUsuario = usuarioMobileService.save(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioMobile>> listarUsuarios() {
        List<UsuarioMobile> usuarios = usuarioMobileService.getAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioMobile> login(@RequestBody UsuarioMobile usuario) {
        UsuarioMobile usuarioLogado = usuarioMobileService.login(usuario);
        if (usuarioLogado != null) {
            return new ResponseEntity<>(usuarioLogado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
