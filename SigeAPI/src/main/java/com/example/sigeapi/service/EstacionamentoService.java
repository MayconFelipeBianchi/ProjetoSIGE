package com.example.sigeapi.service;

import com.example.sigeapi.model.Estacionamento;
import com.example.sigeapi.repository.EstacionamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstacionamentoService {

    private final EstacionamentoRepository estacionamentoRepository;

    public EstacionamentoService(EstacionamentoRepository estacionamentoRepository) {
        this.estacionamentoRepository = estacionamentoRepository;
    }

    public List<Estacionamento> getAllEstacionamentos() {
        return estacionamentoRepository.findAll();
    }

    public Estacionamento getEstacionamentoById(Integer id) {
        return estacionamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estacionamento não encontrado com o id: " + id));
    }

    public Estacionamento saveEstacionamento(Estacionamento estacionamento) {
        return estacionamentoRepository.save(estacionamento);
    }

    public Estacionamento updateEstacionamento(Integer id, Estacionamento estacionamentoDetails) {
        Estacionamento estacionamento = estacionamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estacionamento não encontrado com o id: " + id));

        estacionamento.setNome(estacionamentoDetails.getNome());
        estacionamento.setCnpj(estacionamentoDetails.getCnpj());
        estacionamento.setRua(estacionamentoDetails.getRua());
        estacionamento.setProprietario(estacionamentoDetails.getProprietario());
        estacionamento.setNumero(estacionamentoDetails.getNumero());
        estacionamento.setUrlMaps(estacionamentoDetails.getUrlMaps());

        return estacionamentoRepository.save(estacionamento);
    }

    public void deleteEstacionamento(Integer id) {
        if (!estacionamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Estacionamento não encontrado com o id: " + id);
        }
        estacionamentoRepository.deleteById(id);
    }
}
