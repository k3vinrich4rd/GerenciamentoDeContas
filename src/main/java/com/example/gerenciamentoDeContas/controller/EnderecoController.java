package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.model.EnderecoModel;
import com.example.gerenciamentoDeContas.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(path = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoModel> cadastrarNovoEndereco(@Valid @RequestBody EnderecoModel enderecoModel) {
        EnderecoModel endereco = enderecoService.cadastrarNovosEnderecos(enderecoModel);
        return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoModel>> exibirEnderecosCadastrados() {
        return ResponseEntity.ok(enderecoService.exibirEnderecos());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<EnderecoModel>> exibirViaId(@PathVariable Long codigo) {
        return ResponseEntity.ok(enderecoService.exibirEnderecoViaId(codigo));
    }

    @PutMapping(path = "/{codigo}")
    public ResponseEntity<EnderecoModel> alterarEndereco(@Valid @RequestBody EnderecoModel enderecoModel) {
        return ResponseEntity.ok(enderecoService.alterarEnderecoCadastrado(enderecoModel));
    }

    @DeleteMapping(path = "/{codigo}")
    public void deleterEnderecoCadastrado(@PathVariable Long codigo) {
        enderecoService.deletarEndereco(codigo);
    }
}
