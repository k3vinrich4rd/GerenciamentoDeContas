package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.enumeric.Status;
import com.example.gerenciamentoDeContas.enumeric.Tipo;
import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import com.example.gerenciamentoDeContas.model.request.AlterarStatusPagamentoRequest;
import com.example.gerenciamentoDeContas.model.response.ContasAPagarResponse;
import com.example.gerenciamentoDeContas.service.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Controller com o mapeamento e validated para validações existentes
@RestController
@RequestMapping(path = "/contas")
public class ContasAPagarController {

    @Autowired
    private ContasAPagarService contasAPagarService;

    @PostMapping
    public ResponseEntity<ContasAPagarModel> cadastrarNovaConta(@RequestBody ContasAPagarModel contasAPagarModel) {
        ContasAPagarModel contas = contasAPagarService.cadastrarContas(contasAPagarModel);
        return new ResponseEntity<>(contas, HttpStatus.CREATED); // Retorna 200
    }

    @GetMapping
    public ResponseEntity<List<ContasAPagarResponse>> exibirTodosOsRegistrosDePagamento() {
        return ResponseEntity.ok(contasAPagarService.exibirTodosRegistrosDePagamento());
    }


    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<ContasAPagarModel>> exibirPagamentosViaId(@PathVariable UUID codigo) {
        if (!contasAPagarService.existsById(codigo)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contasAPagarService.exibirContasViaId(codigo));
    }


    @GetMapping(path = "/status/{status}") //Query method (método de busca)
    public ResponseEntity<List<ContasAPagarModel>> exibirStatusDoPagamento(@PathVariable Status status) {
        return ResponseEntity.ok(contasAPagarService.findByStatus(status));
    }

    //Query method (método de busca)
    @GetMapping(path = "/tipo/{tipo}") //Query method (método de busca)
    public ResponseEntity<List<ContasAPagarModel>> exibirTipoDoPagamento(@PathVariable Tipo tipo) {
        return ResponseEntity.ok(contasAPagarService.findByTipo(tipo));
    }


    @PutMapping(path = "/{codigo}")
    public ResponseEntity<ContasAPagarModel> alterarStatusDasContas(@Valid @PathVariable UUID codigo, @RequestBody AlterarStatusPagamentoRequest alterarStatusPagamentoRequest) {
        if (!contasAPagarService.existsById(codigo)) {
            return ResponseEntity.notFound().build(); // Retorna 404
        }
        return ResponseEntity.ok(contasAPagarService.alterarRegistrosDePagamento(alterarStatusPagamentoRequest, codigo));
    }


    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o 204
    public ResponseEntity deletar(@PathVariable UUID codigo) {
        if (!contasAPagarService.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Id não encontrado");
        }
        contasAPagarService.deletarConta(codigo);
        return null;
    }

}

