package com.example.gerenciamentoDeContas.model.response;

import com.example.gerenciamentoDeContas.enumeric.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/// Perguntar para a Grazi

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContasAPagarResponse {
    private Long id;
    private String nome;
    private Double valor;
    private Status status;

}
