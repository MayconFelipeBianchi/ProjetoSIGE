package com.example.sigeapi.repository;

import com.example.sigeapi.model.Vagas;
import com.example.sigeapi.model.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VagasRepository extends JpaRepository<Vagas, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Vagas v SET v.status = :status WHERE v.id = :id")
    void updateStatusById(Integer id, Integer status);

    List<Vagas> findByEstacionamento(Estacionamento estacionamento);
}
