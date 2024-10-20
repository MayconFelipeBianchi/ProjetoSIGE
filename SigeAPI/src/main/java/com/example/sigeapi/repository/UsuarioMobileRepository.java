package com.example.sigeapi.repository;

import com.example.sigeapi.model.UsuarioMobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioMobileRepository extends JpaRepository <UsuarioMobile, Integer>{
}
