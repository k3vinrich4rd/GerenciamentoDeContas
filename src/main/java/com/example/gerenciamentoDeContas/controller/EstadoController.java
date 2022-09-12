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

@RestController
@Validated
@RequestMapping(path = "/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<EstadoModel> cadastrarEstados(@Valid @RequestBody EstadoModel estadoModel){
        EstadoModel estado = estadoService.cadastrarEstados(estadoModel);
        return new ResponseEntity<>(estado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EstadoModel>> exibirEstadosCadastrados(){
        return ResponseEntity.ok(estadoService.exibirEstados());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<EstadoModel>> exibirEstadosViaId(@PathVariable Long id){
        return ResponseEntity.ok(estadoService.exibirEstadosViaId(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EstadoModel> alterarEstadosCadastrados(@Valid @RequestBody EstadoModel estadoModel){
        return ResponseEntity.ok(estadoService.alterarEstadosCadastrados(estadoModel));
    }

    @DeleteMapping(path = "/{id}")
    public void deletarEstadosCadastrados(@PathVariable Long id){
        estadoService.deletarEstados(id);
    }
}
