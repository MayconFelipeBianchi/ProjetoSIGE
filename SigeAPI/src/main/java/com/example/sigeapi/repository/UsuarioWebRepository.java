package com.example.sigeapi.repository;

import com.example.sigeapi.model.UsuarioWeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioWebRepository extends JpaRepository<UsuarioWeb, Integer> {

    Optional<UsuarioWeb> findByEmailW(String emailW);
}
