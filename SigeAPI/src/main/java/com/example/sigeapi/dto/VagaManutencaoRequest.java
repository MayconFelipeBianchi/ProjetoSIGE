package com.example.sigeapi.dto;

public class VagaManutencaoRequest {
    private int vaga;
    private String motivo;

    public int getVaga() {
        return vaga;
    }

    public void setVaga(int vaga) {
        this.vaga = vaga;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
