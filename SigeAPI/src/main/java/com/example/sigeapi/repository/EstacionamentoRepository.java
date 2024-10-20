package com.example.sigeapi.repository;

import com.example.sigeapi.model.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Integer> {
}
