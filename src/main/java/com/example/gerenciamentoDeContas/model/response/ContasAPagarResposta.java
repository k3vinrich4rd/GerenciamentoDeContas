package com.example.gerenciamentoDeContas.model.response;

import com.example.gerenciamentoDeContas.enumeric.Status;
import com.example.gerenciamentoDeContas.enumeric.Tipo;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
public class ContasAPagarResposta {
    private Long id;
    private String nome;
    private Double valor;
    private Status status;

}
