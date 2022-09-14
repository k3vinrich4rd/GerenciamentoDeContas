package com.example.gerenciamentoDeContas.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContasAReceberResponse {
    private Long codigo;
    private String nomeUsuario;
    private LocalDate dataDeNascimento;
    private String email;
}
