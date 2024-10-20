package com.example.sigeapi.service;

import com.example.sigeapi.model.UsuarioWeb;
import com.example.sigeapi.repository.UsuarioWebRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioWebService {
    private final UsuarioWebRepository usuarioWebRepository;

    public UsuarioWebService(UsuarioWebRepository usuarioWebRepository) {
        this.usuarioWebRepository = usuarioWebRepository;
    }

    public List<UsuarioWeb> getAll() {
        return this.usuarioWebRepository.findAll();
    }

    public UsuarioWeb save(UsuarioWeb usuario) {
        return this.usuarioWebRepository.save(usuario);
    }

    public UsuarioWeb login(UsuarioWeb usuario) {
        List<UsuarioWeb> userArray = this.usuarioWebRepository.findAll();
        for (UsuarioWeb user : userArray) {
            if (user.getNomeW() != null && user.getNomeW().equals(usuario.getNomeW()) && user.getSenhaW().equals(usuario.getSenhaW())) {
                return user;
            }
        }
        return null;
    }
}
