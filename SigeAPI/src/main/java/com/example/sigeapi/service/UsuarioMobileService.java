package com.example.sigeapi.service;

import com.example.sigeapi.model.UsuarioMobile;
import com.example.sigeapi.repository.UsuarioMobileRepository;
import java.util.List;
import org.springframework.stereotype.Service;



@Service
public class UsuarioMobileService {
    private final UsuarioMobileRepository usuarioMobileRepository;

    public UsuarioMobileService(UsuarioMobileRepository usuarioMobileRepository) {
        this.usuarioMobileRepository = usuarioMobileRepository;
    }
    public List<UsuarioMobile> getAll() {
        return this.usuarioMobileRepository.findAll();
    }

    public UsuarioMobile save(UsuarioMobile usuario) {
        return this.usuarioMobileRepository.save(usuario);
    }

    public UsuarioMobile login(UsuarioMobile usuario) {
        List<UsuarioMobile> userArray = this.usuarioMobileRepository.findAll();
        for (UsuarioMobile user : userArray) {
            if (user.getNome() != null && user.getNome().equals(usuario.getNome()) && user.getSenha().equals(usuario.getSenha())) {
                return user;
            }
        }
        return null;
    }
}
