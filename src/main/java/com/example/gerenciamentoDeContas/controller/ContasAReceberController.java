package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;
import com.example.gerenciamentoDeContas.service.ContasAReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/contasAReceber")
public class ContasAReceberController {

    @Autowired
    private ContasAReceberService contasAReceberService;

    @PostMapping
    public ResponseEntity<ContasReceberModel> cadastrarContaDeRecebimento(@RequestBody ContasReceberModel contasReceberModel) {
        ContasReceberModel contas = contasAReceberService.cadastrarUmaNovaConta(contasReceberModel);
        return new ResponseEntity<>(contas, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContasReceberModel>> exibirContasCadastradas() {
        return ResponseEntity.ok(contasAReceberService.exibirContas());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<ContasReceberModel>> exibirContasViaId(@PathVariable Long codigo) {
        return ResponseEntity.ok(contasAReceberService.exibirViaId(codigo));
    }

    @PutMapping(path = "/{codigo}")
    public ResponseEntity<ContasReceberModel> alterarContasCadastradas(@RequestBody ContasReceberModel contasReceberModel) {
        return ResponseEntity.ok(contasAReceberService.atualizarContas(contasReceberModel));
    }

    @DeleteMapping(path = "/{codigo}")
    public void deletarContasCadastradas(@PathVariable Long codigo) {
        contasAReceberService.deletarContasCgadastradas(codigo);
    }

}
