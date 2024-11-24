package com.example.sigeapi.controller;

import com.example.sigeapi.dto.VagaManutencaoRequest;
import com.example.sigeapi.model.StatusVaga;
import com.example.sigeapi.model.Vagas;
import com.example.sigeapi.service.VagasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vagas")
public class VagasController {

    @Autowired
    private VagasService vagasService;

    @PostMapping
    public ResponseEntity<Vagas> cadastrarVaga(@RequestBody Vagas vaga) {
        try {
            Vagas novaVaga = vagasService.cadastrarVaga(vaga);
            return new ResponseEntity<>(novaVaga, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<Vagas> finalizarVaga(@PathVariable Integer id) {
        Vagas vagaAtualizada = vagasService.finalizarVaga(id);
        return ResponseEntity.ok(vagaAtualizada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vagas> atualizarVaga(@PathVariable Integer id, @RequestParam int status) {
        try {
            StatusVaga statusVaga = StatusVaga.fromCode(status);
            Vagas vagaAtualizada = vagasService.atualizarStatusVaga(id, statusVaga.getCode());
            return new ResponseEntity<>(vagaAtualizada, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVaga(@PathVariable Integer id) {
        try {
            vagasService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Vagas> listarTodasVagas() {
        return vagasService.listarTodasVagas();
    }

    @PostMapping("/{id}/manutencao")
    public ResponseEntity<Vagas> confirmarManutencao(@PathVariable Integer id, @RequestBody VagaManutencaoRequest request) {
        try {
            Vagas vagaAtualizada = vagasService.confirmarManutencao(id, request.getMotivo());
            return new ResponseEntity<>(vagaAtualizada, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
