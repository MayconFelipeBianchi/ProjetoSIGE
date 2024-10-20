package com.example.sigeapi.repository;

import com.example.sigeapi.model.UsuarioWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioWebRepository extends JpaRepository <UsuarioWeb, Integer>{
}
