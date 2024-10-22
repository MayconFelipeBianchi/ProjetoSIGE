package com.example.sigeapi.controller;

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
        Vagas novaVaga = vagasService.cadastrarVaga(vaga);
        return new ResponseEntity<>(novaVaga, HttpStatus.CREATED);
    }

  //  @GetMapping
   // public ResponseEntity<List<Vagas>> listarVagas(@RequestParam(required = false) Integer estacionamentoId) {
     //   List<Vagas> vagas = vagasService.listarVagasPorEstacionamento(estacionamentoId);
       // return new ResponseEntity<>(vagas, HttpStatus.OK);
    //}

    @PutMapping("/{id}")
    public ResponseEntity<Vagas> atualizarVaga(@PathVariable Integer id, @RequestBody Vagas vaga) {
        Vagas vagaAtualizada = vagasService.atualizarStatusVaga(id, vaga.isStatus());
        return new ResponseEntity<>(vagaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVaga(@PathVariable Integer id) {
        vagasService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
