package com.example.sigeapi.controller;

import com.example.sigeapi.dto.VagaManutencaoRequest;
import com.example.sigeapi.model.Manutencao;
import com.example.sigeapi.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManutencaoController {

    @Autowired
    private ManutencaoService manutencaoService;

    @GetMapping("/manutencao")
    public String mostrarFormulario() {
        return "manutencao";
    }

    @GetMapping("/api/manutencao")
    @ResponseBody
    public List<Manutencao> getManutencao(@RequestParam(required = false) Integer vagaId) {
        if (vagaId != null) {
            return manutencaoService.obterManutencaoPorVaga(vagaId);
        }
        return manutencaoService.obterTodasManutencao();
    }

    @PostMapping("/api/vagas/manutencao")
    @ResponseBody
    public Map<String, String> confirmarManutencao(@RequestBody VagaManutencaoRequest request) {
        int vagaId = request.getVaga();
        String motivoManutencao = request.getMotivo();

        boolean atualizado = manutencaoService.atualizarStatusVaga(vagaId, motivoManutencao);

        Map<String, String> response = new HashMap<>();
        if (atualizado) {
            response.put("success", "true");
            response.put("message", "Manutenção concluída com sucesso!");
        } else {
            response.put("success", "false");
            response.put("message", "Erro ao concluir a manutenção.");
        }

        return response;
    }
}
