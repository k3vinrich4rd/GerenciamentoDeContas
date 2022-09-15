package com.example.gerenciamentoDeContas.model.Dto;

import com.example.gerenciamentoDeContas.model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModelDto {

    private Long codigo;
    private String nomeUsuario;
    private LocalDate dataDeNascimento;
    private String email;

    public UsuarioModelDto(UsuarioModel obj) {
        this.codigo = obj.getCodigo();
        this.nomeUsuario = obj.getNomeUsuario();
        this.dataDeNascimento = obj.getDataDeNascimento();
        this.email = obj.getEmail();
    }
}
