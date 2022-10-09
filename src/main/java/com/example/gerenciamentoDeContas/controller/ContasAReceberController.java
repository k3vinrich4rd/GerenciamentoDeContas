package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.enumeric.TipoRecebimento;
import com.example.gerenciamentoDeContas.model.ContasReceberModel;
import com.example.gerenciamentoDeContas.repository.IContasAReceberRepository;
import com.example.gerenciamentoDeContas.service.ContasAReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Controller com o mapeamento e validated para validações existentes
@RestController
@Validated
@RequestMapping(path = "/contasAReceber")
public class ContasAReceberController {

    @Autowired
    private ContasAReceberService contasAReceberService;


    @PostMapping
    public ResponseEntity<ContasReceberModel> cadastrarContaDeRecebimento(@Valid @RequestBody ContasReceberModel contasReceberModel) {
        ContasReceberModel contas = contasAReceberService.cadastrarNovoRecebimento(contasReceberModel);
        return new ResponseEntity<>(contas, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContasReceberModel>> exibirContasCadastradas() {
        return ResponseEntity.ok(contasAReceberService.exibirTodosRecebimentos());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<ContasReceberModel>> exibirContasViaId(@Valid @PathVariable UUID codigo) {
        return ResponseEntity.ok(contasAReceberService.exibirRecebimentoViaId(codigo));
    }

    @GetMapping(path = "/dataDeVencimento/{dataDeVencimento}")
    public ResponseEntity<List<ContasReceberModel>> exibirViaDataDeVencimento(@PathVariable String dataDeVencimento){
        return ResponseEntity.ok(contasAReceberService.exibirViaDataDeVencimento(dataDeVencimento));
    }

    @GetMapping(path = "/statusContasAReceber/{status}")
    public ResponseEntity<List<ContasReceberModel>> exibirViaStatusContasReceber(@PathVariable String status){
        return ResponseEntity.ok(contasAReceberService.exibirStatusContasAReceber(status));
    }

    @GetMapping(path = "/tipoRecebimentoContasAReceber/{tipoRecebimento}")
    public ResponseEntity<List<ContasReceberModel>> exibirViaTipoRecebimento(@PathVariable TipoRecebimento tipoRecebimento){
        return ResponseEntity.ok(contasAReceberService.exibirViaTipoRecebimento(tipoRecebimento));
    }


    @PutMapping(path = "/{codigo}")
    public ResponseEntity<ContasReceberModel> alterarContasCadastradas(@Valid @PathVariable UUID codigo, @RequestBody ContasReceberModel contasReceberModel) {
        if (!contasAReceberService.existsById(codigo)) {
            return ResponseEntity.notFound().build(); // retorna 422
        }
        return ResponseEntity.ok(contasAReceberService.atualizarContas(contasReceberModel));
    }

    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o 204
    public ResponseEntity deletar(@PathVariable UUID codigo) {
        if (!contasAReceberService.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Id não encontrado");

        }
        contasAReceberService.deletarContasCadastradas(codigo);
        return null;
    }


}
