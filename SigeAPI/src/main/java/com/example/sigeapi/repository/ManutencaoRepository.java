package com.example.sigeapi.repository;

import com.example.sigeapi.model.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Integer> {
    List<Manutencao> findByVagaId(Integer vagaId);
}
