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

@RestController
@Validated
@RequestMapping(path = "/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private IEnderecoRepository iEnderecoRepository;

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
    public ResponseEntity<Optional<EnderecoModel>> exibirEnderecosViaId(@PathVariable Long codigo) {
        return ResponseEntity.ok(enderecoService.exibirEnderecosViaId(codigo));
    }

    @PutMapping(path = "/{codigo}")
    public ResponseEntity<EnderecoModel> alterarEnderecosCadastrados(@Valid @PathVariable Long codigo, @RequestBody EnderecoModel enderecoModel) {
        if (!iEnderecoRepository.existsById(codigo)) {
            return ResponseEntity.unprocessableEntity().build(); // retorna 422
        }
        return ResponseEntity.ok(enderecoService.alterarEnderecosCadastrados(enderecoModel, codigo));
    }


    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o 204
    public ResponseEntity deletar(@PathVariable Long codigo) {
        if (!iEnderecoRepository.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Id não encontrado");

        }
        enderecoService.deletarEnderecosCadastrados(codigo);
        return null;
    }
}
