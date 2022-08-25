package com.example.gerenciamentoDeContas.model.request;

import com.example.gerenciamentoDeContas.enumeric.Status;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
public class AlterarStatusPagamentoRequest {

    @Enumerated(EnumType.STRING)
    private Status status;

}
