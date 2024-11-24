package com.example.sigeapi.service;

import com.example.sigeapi.model.Estacionamento;
import com.example.sigeapi.model.Vagas;
import com.example.sigeapi.repository.EstacionamentoRepository;
import com.example.sigeapi.repository.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagasService {

    @Autowired
    private VagasRepository vagasRepository;

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public Vagas cadastrarVaga(Vagas vaga) {
        if (!isValidStatus(vaga.getStatus())) {
            throw new IllegalArgumentException("Status da vaga inválido.");
        }
        if (vaga.getEstacionamento() == null || vaga.getEstacionamento().getId() == null) {
            throw new IllegalArgumentException("Vaga precisa estar associada a um estacionamento.");
        }

        Estacionamento estacionamento = estacionamentoRepository.findById(vaga.getEstacionamento().getId())
                .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado."));
        vaga.setEstacionamento(estacionamento);

        return vagasRepository.save(vaga);
    }

    public List<Vagas> listarTodasVagas() {
        return vagasRepository.findAll();
    }

    public List<Vagas> listarVagasPorEstacionamento(Integer estacionamentoId) {
        Estacionamento estacionamento = estacionamentoRepository.findById(estacionamentoId)
                .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado."));
        return vagasRepository.findByEstacionamento(estacionamento);
    }

    public Vagas atualizarStatusVaga(Integer id, Integer statusCode) {
        if (!isValidStatus(statusCode)) {
            throw new IllegalArgumentException("Status inválido.");
        }

        Vagas vaga = vagasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));

        vaga.setStatus(statusCode);
        return vagasRepository.save(vaga);
    }

    public void delete(Integer id) {
        if (!vagasRepository.existsById(id)) {
            throw new RuntimeException("Vaga não encontrada.");
        }
        vagasRepository.deleteById(id);
    }

    public Vagas confirmarManutencao(Integer vagaId, String motivo) {
        Vagas vaga = vagasRepository.findById(vagaId)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada."));

        vaga.setStatus(2);

        System.out.println("Motivo da manutenção: " + motivo);
        return vagasRepository.save(vaga);
    }

    private boolean isValidStatus(Integer statusCode) {
        return statusCode != null && (statusCode == 0 || statusCode == 1 || statusCode == 2);
    }

    public Vagas finalizarVaga(Integer id) {
        Vagas vaga = vagasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada."));

        vaga.setStatus(0);
        return vagasRepository.save(vaga);
    }
}
