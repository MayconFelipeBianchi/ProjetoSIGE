package com.example.sigeapi.model;

public enum StatusVaga {
    VAZIA(0),
    PREENCHEIDA(1),
    EM_MANUTENCAO(2);

    private final int code;

    StatusVaga(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusVaga fromCode(int code) {
        for (StatusVaga status : StatusVaga.values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status inválido: " + code);
    }
}