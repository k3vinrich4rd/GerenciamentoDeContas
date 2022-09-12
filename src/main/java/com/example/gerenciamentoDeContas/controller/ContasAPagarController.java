package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.enumeric.Status;
import com.example.gerenciamentoDeContas.enumeric.Tipo;
import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import com.example.gerenciamentoDeContas.model.request.AlterarStatusPagamentoRequest;
import com.example.gerenciamentoDeContas.model.response.ContasAPagarResponse;
import com.example.gerenciamentoDeContas.repository.IContasAPagarRepository;
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
    private IContasAPagarRepository contasAPagarRepository;


    @PostMapping
    public ResponseEntity<ContasAPagarModel> cadastrarNovaConta(@RequestBody ContasAPagarModel contasAPagarModel) {
        ContasAPagarModel contas = contasAPagarService.cadastrarContas(contasAPagarModel);
        return new ResponseEntity<>(contas, HttpStatus.CREATED); // Retorna 200
    }

    @GetMapping
    public ResponseEntity<List<ContasAPagarResponse>> exibirTodosOsRegistrosDePagamento() {
        return ResponseEntity.ok(contasAPagarService.exibirTodosRegistrosDePagamento());
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ContasAPagarModel>> exibirPagamentosViaId(@PathVariable Long id) {
        if (!contasAPagarRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contasAPagarService.exibirContasViaId(id));
    }

    @GetMapping(path = "/status/{status}")
    public ResponseEntity<List<ContasAPagarModel>> exibirStatusDoPagamento(@PathVariable Status status) {
        return ResponseEntity.ok(contasAPagarRepository.findByStatus(status));
    }

    @GetMapping(path = "/tipo/{tipo}")
    public ResponseEntity<List<ContasAPagarModel>> exibirTipoDoPagamento(@PathVariable Tipo tipo) {
        return ResponseEntity.ok(contasAPagarRepository.findByTipo(tipo));
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<ContasAPagarModel> alterarStatusDasContas(@RequestBody AlterarStatusPagamentoRequest alterarStatusPagamentoRequest, @PathVariable Long id) {
        if (!contasAPagarRepository.existsById(id)) {
            return ResponseEntity.unprocessableEntity().build(); // Retorna 422
        }
        return ResponseEntity.ok(contasAPagarService.alterarRegistrosDePagamento(alterarStatusPagamentoRequest, id));
    }


    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o 204
    public ResponseEntity deletar(@PathVariable Long id) {
        if (!contasAPagarRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Id não encontrado");

        }
        contasAPagarService.deletarConta(id);
        return null;
    }

}

