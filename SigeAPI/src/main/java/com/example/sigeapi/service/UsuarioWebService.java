package com.example.sigeapi.service;

import com.example.sigeapi.model.UsuarioWeb;
import com.example.sigeapi.repository.UsuarioWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioWebService {

    private final UsuarioWebRepository usuarioWebRepository;

    @Autowired
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
        Optional<UsuarioWeb> usuarioOptional = usuarioWebRepository.findByEmailW(usuario.getEmailW());

        if (usuarioOptional.isPresent()) {
            UsuarioWeb user = usuarioOptional.get();
            if (user.getSenhaW().equals(usuario.getSenhaW())) {
                return user;
            }
        }

        return null;
    }
}
