package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.model.EnderecoModel;
import com.example.gerenciamentoDeContas.repository.IEnderecoRepository;
import com.example.gerenciamentoDeContas.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Controller com o mapeamento e validated para validações existentes
@RestController
@Validated
@RequestMapping(path = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoModel> cadastrarEndereco(@Valid @RequestBody EnderecoModel enderecoModel) {
        EnderecoModel endereco = enderecoService.cadastrarEndereco(enderecoModel);
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoModel>> exibirTodosEnderecos() {
        return ResponseEntity.ok(enderecoService.exibirTodosEnderecos());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<EnderecoModel>> exibirEnderecosViaId(@PathVariable UUID codigo) {
        return ResponseEntity.ok(enderecoService.exibirEnderecosViaId(codigo));
    }

    @PutMapping(path = "/{codigo}")
    public ResponseEntity<EnderecoModel> alterarEnderecosCadastrados(@Valid @PathVariable UUID codigo, @RequestBody EnderecoModel enderecoModel) {
        if (!enderecoService.existsById(codigo)) {
            return ResponseEntity.notFound().build(); // retorna 404
        }
        return ResponseEntity.ok(enderecoService.alterarEnderecosCadastrados(enderecoModel, codigo));
    }


    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o 204
    public ResponseEntity deletar(@PathVariable UUID codigo) {
        if (!enderecoService.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Id não encontrado");
        }
        enderecoService.deletarEnderecosCadastrados(codigo);
        return null;
    }
}
