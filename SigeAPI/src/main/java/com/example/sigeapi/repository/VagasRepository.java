package com.example.sigeapi.repository;

import com.example.sigeapi.model.Vagas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagasRepository extends JpaRepository<Vagas, Integer> {
    List<Vagas> findByEstacionamentoId(Integer estacionamentoId);
}
