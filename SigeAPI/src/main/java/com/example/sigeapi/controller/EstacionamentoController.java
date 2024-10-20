package com.example.sigeapi.controller;

import com.example.sigeapi.model.Estacionamento;
import com.example.sigeapi.service.EstacionamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estacionamentos")
public class EstacionamentoController {

    private final EstacionamentoService estacionamentoService;

    public EstacionamentoController(EstacionamentoService estacionamentoService) {
        this.estacionamentoService = estacionamentoService;
    }

    @GetMapping
    public List<Estacionamento> getAllEstacionamentos() {
        return estacionamentoService.getAllEstacionamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estacionamento> getEstacionamentoById(@PathVariable Integer id) {
        Estacionamento estacionamento = estacionamentoService.getEstacionamentoById(id);
        if (estacionamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estacionamento);
    }

    @PostMapping
    public Estacionamento createEstacionamento(@RequestBody Estacionamento estacionamento) {
        return estacionamentoService.saveEstacionamento(estacionamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estacionamento> updateEstacionamento(@PathVariable Integer id, @RequestBody Estacionamento estacionamentoDetails) {
        Estacionamento updatedEstacionamento = estacionamentoService.updateEstacionamento(id, estacionamentoDetails);
        if (updatedEstacionamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEstacionamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstacionamento(@PathVariable Integer id) {
        estacionamentoService.deleteEstacionamento(id);
        return ResponseEntity.noContent().build();
    }
}
