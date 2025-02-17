package com.example.sigeapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class UsuarioWeb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email_w")
    private String emailW;

    @Column(name = "senha_w")
    private String senhaW;

    public UsuarioWeb(String emailW, String senhaW) {
        this.emailW = emailW;
        this.senhaW = senhaW;
    }

    public UsuarioWeb() {
    }
}