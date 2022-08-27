package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import com.example.gerenciamentoDeContas.model.request.AlterarStatusPagamentoRequest;
import com.example.gerenciamentoDeContas.model.response.ContasAPagarResponse;
import com.example.gerenciamentoDeContas.repository.ContasAPagarRepository;
import com.example.gerenciamentoDeContas.service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/contas")
public class ContasAPagarController {

    @Autowired
    private ContasAPagarService contasAPagarService;

    @Autowired
    private ContasAPagarRepository contasAPagarRepository;


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
        if (!contasAPagarRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contasAPagarService.exibirContasViaId(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ContasAPagarModel> alterarStatusDasContas(@RequestBody AlterarStatusPagamentoRequest alterarStatusPagamentoRequest, @PathVariable Long id) {
        if (!contasAPagarRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contasAPagarService.alterarRegistrosDePagamento(alterarStatusPagamentoRequest, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        if (!contasAPagarRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Id não encontrado");

        }
        contasAPagarService.deletarConta(id);
        return null;
    }

}

