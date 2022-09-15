package com.example.gerenciamentoDeContas.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PadraoErro implements Serializable { // Tratamento de erro para not Foundl

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
