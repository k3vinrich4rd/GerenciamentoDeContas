package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.model.EstadoModel;
import com.example.gerenciamentoDeContas.service.EstadoService;
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
@RequestMapping(path = "/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<EstadoModel> cadastrarEstados(@Valid @RequestBody EstadoModel estadoModel) {
        EstadoModel estado = estadoService.cadastrarEstados(estadoModel);
        return new ResponseEntity<>(estado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EstadoModel>> exibirEstadosCadastrados() {
        return ResponseEntity.ok(estadoService.exibirEstados());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<EstadoModel>> exibirEstados(@PathVariable UUID codigo) {
        return ResponseEntity.ok(estadoService.exibirEstadoViaId(codigo));
    }

    @PutMapping(path = "/{codigo}")
    public ResponseEntity<EstadoModel> alterarEstadosCadastrados(@Valid @PathVariable UUID codigo, @RequestBody EstadoModel estadoModel) {
        if (!estadoService.existsById(codigo)) {
            return ResponseEntity.notFound().build(); // retorna 404
        }
        return ResponseEntity.ok(estadoService.alterarEstadoCadastrado(estadoModel, codigo));
    }

    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o 204
    public ResponseEntity deletar(@PathVariable UUID codigo) {
        if (!estadoService.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Id não encontrado");

        }
        estadoService.deletarEstados(codigo);
        return null;
    }
}
