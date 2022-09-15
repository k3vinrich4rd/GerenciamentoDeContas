package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.model.CidadeModel;
import com.example.gerenciamentoDeContas.repository.ICidadeRepository;
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

    @Autowired
    private ICidadeRepository iCidadeRepository;

    @PostMapping
    public ResponseEntity<CidadeModel> cadastrarCidade(@Valid @RequestBody CidadeModel cidadeModel) {
        CidadeModel cidade = cidadeService.cadastrarCidade(cidadeModel);
        return new ResponseEntity<>(cidade, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CidadeModel>> exibirCidadesCadastrada() {
        return ResponseEntity.ok(cidadeService.exibirTodasAsCidades());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<CidadeModel>> exibirCidadesViaId(@PathVariable Long codigo) {
        return ResponseEntity.ok(cidadeService.exibirCidadeViaId(codigo));
    }

    @PutMapping(path = "/{codigo}")
    public ResponseEntity<CidadeModel> alterarContasCadastradas(@Valid @PathVariable Long codigo, @RequestBody CidadeModel cidadeModel) {
        if (!iCidadeRepository.existsById(codigo)) {
            return ResponseEntity.unprocessableEntity().build(); // retorna 422
        }
        return ResponseEntity.ok(cidadeService.alterarCidadeCadastrada(cidadeModel, codigo));
    }


    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o 204
    public ResponseEntity deletar(@PathVariable Long codigo) {
        if (!iCidadeRepository.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Id não encontrado");

        }
        cidadeService.deletarCidadesCadastradas(codigo);
        return null;
    }
}
