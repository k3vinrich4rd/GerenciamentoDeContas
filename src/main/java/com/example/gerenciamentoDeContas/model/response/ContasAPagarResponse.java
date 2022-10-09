package com.example.gerenciamentoDeContas.model.response;

import com.example.gerenciamentoDeContas.enumeric.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

//Response criada para exibir somente alguns atributos em específico
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContasAPagarResponse {
    private UUID codigo;
    private String nome;
    private Double valor;
    private Status status;

}
