package com.example.sigeapi.service;

import com.example.sigeapi.model.Vagas;
import com.example.sigeapi.repository.VagasRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagasService {
    private final VagasRepository vagaRepository;

    public VagasService(VagasRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    public Vagas cadastrarVaga(Vagas vaga) {
        return vagaRepository.save(vaga);
    }

    public List<Vagas> listarVagasPorEstacionamento(Integer estacionamentoId) {
        return vagaRepository.findByEstacionamentoId(estacionamentoId);
    }

    public Vagas atualizarStatusVaga(Integer id, boolean status) {
        return vagaRepository.findById(id)
                .map(vaga -> {
                    vaga.setStatus(status);
                    return vagaRepository.save(vaga);
                }).orElseThrow(() -> new EntityNotFoundException("Vaga não encontrada"));
    }

    public void delete(Integer id) {
        if (!vagaRepository.existsById(id)) {
            throw new EntityNotFoundException("Vaga não encontrada com o id: " + id);
        }
        vagaRepository.deleteById(id);
    }
}
