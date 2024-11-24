package com.example.sigeapi.service;

import com.example.sigeapi.model.Manutencao;
import com.example.sigeapi.model.Vagas;
import com.example.sigeapi.repository.ManutencaoRepository;
import com.example.sigeapi.repository.VagasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManutencaoService {

    @Autowired
    private ManutencaoRepository manutencaoRepository;
    @Autowired
    private VagasRepository vagasRepository;

    public List<Manutencao> obterTodasManutencao() {
        return manutencaoRepository.findAll();
    }

    public List<Manutencao> obterManutencaoPorVaga(Integer vagaId) {
        return manutencaoRepository.findByVagaId(vagaId);
    }

    @Transactional
    public boolean atualizarStatusVaga(Integer vagaId, String motivo) {
        try {
            Vagas vaga = vagasRepository.findById(vagaId)
                    .orElseThrow(() -> new IllegalArgumentException("Vaga não encontrada com ID: " + vagaId));

            vaga.setStatus(2);
            vagasRepository.save(vaga);

            Manutencao manutencao = new Manutencao();
            manutencao.setMotivo(motivo);
            manutencao.setVaga(vaga);
            manutencaoRepository.save(manutencao);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
