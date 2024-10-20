package com.example.sigeapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class UsuarioWeb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_w")
    private String nomeW;

    @Column(name = "email_w")
    private String emailW;

    @Column(name = "senha_w")
    private String senhaW;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeW() {
        return nomeW;
    }

    public void setNomeW(String nomeW) {
        this.nomeW = nomeW;
    }

    public String getEmailW() {
        return emailW;
    }

    public void setEmailW(String emailW) {
        this.emailW = emailW;
    }

    public String getSenhaW() {
        return senhaW;
    }

    public void setSenhaW(String senhaW) {
        this.senhaW = senhaW;
    }
}
