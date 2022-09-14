package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.model.CidadeModel;
import com.example.gerenciamentoDeContas.service.CidadeService;
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
@RequestMapping(path = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<CidadeModel> cadastrarCidade(@Valid @RequestBody CidadeModel cidadeModel) {
        CidadeModel cidade = cidadeService.cadastrarCidade(cidadeModel);
        return new ResponseEntity<>(cidade, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CidadeModel>> exibirCidadesCadastrada() {
        return ResponseEntity.ok(cidadeService.exibirCidades());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<CidadeModel>> exibirCidadesViaId(@PathVariable Long codigo) {
        return ResponseEntity.ok(cidadeService.exibirCidadesViaId(codigo));
    }

    @PutMapping(path = "/{codigo}")
    public ResponseEntity<CidadeModel> alterarCidadeCadastrada(@Valid @RequestBody CidadeModel cidadeModel) {
        return ResponseEntity.ok(cidadeService.alterarCidadesCadastradas(cidadeModel));
    }


    @DeleteMapping(path = "/{codigo}")
    public void deletarCidadesCadastradas(@PathVariable Long codigo) {
        cidadeService.deletarCidadesCadastradas(codigo);
    }
}