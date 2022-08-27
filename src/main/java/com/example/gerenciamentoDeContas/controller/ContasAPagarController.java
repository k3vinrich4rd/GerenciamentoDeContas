package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import com.example.gerenciamentoDeContas.model.request.AlterarStatusPagamentoRequest;
import com.example.gerenciamentoDeContas.model.response.ContasAPagarResponse;
import com.example.gerenciamentoDeContas.service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/contas")
public class ContasAPagarController {

    @Autowired
    private ContasAPagarService contasAPagarService;

    @PostMapping
    public ResponseEntity<ContasAPagarModel> cadastrarNovaConta(@RequestBody ContasAPagarModel contasAPagarModel) {
        ContasAPagarModel contas = contasAPagarService.cadastrarContas(contasAPagarModel);
        return new ResponseEntity<>(contas, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<ContasAPagarResponse>> exibirTodosOsRegistrosDePagamento() {
        return ResponseEntity.ok(contasAPagarService.exibirTodosRegistrosDePagamento());
    }


    @GetMapping(path = "/{id}")
    ResponseEntity<Optional<ContasAPagarModel>> exibirPagamentosViaId(@PathVariable Long id) {
        return ResponseEntity.ok(contasAPagarService.exibirContasViaId(id));
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<ContasAPagarModel> alterarStatusDasContas(@RequestBody AlterarStatusPagamentoRequest alterarStatusPagamentoRequest, @PathVariable Long id) {
        return ResponseEntity.ok(contasAPagarService.alterarRegistrosDePagamento(alterarStatusPagamentoRequest, id));
    }


}

