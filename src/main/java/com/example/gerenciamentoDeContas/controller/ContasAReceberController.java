package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;
import com.example.gerenciamentoDeContas.model.response.ContasAReceberResponse;
import com.example.gerenciamentoDeContas.repository.IContasAReceberRepository;
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

    @Autowired
    private IContasAReceberRepository iContasAReceberRepository;

    @PostMapping
    public ResponseEntity<ContasReceberModel> cadastrarContaDeRecebimento(@RequestBody ContasReceberModel contasReceberModel) {
        ContasReceberModel contas = contasAReceberService.cadastrarNovoRecebimento(contasReceberModel);
        return new ResponseEntity<>(contas, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ContasAReceberResponse>> exibirContasCadastradas() {
        return ResponseEntity.ok(contasAReceberService.exibirTodosRecebimentos());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<ContasReceberModel>> exibirContasViaId(@PathVariable Long codigo) {
        return ResponseEntity.ok(contasAReceberService.exibirViaId(codigo));
    }

    @PutMapping(path = "/{codigo}")
    public ResponseEntity<ContasReceberModel> alterarContasCadastradas(@RequestBody ContasReceberModel contasReceberModel, @PathVariable Long codigo) {
        if (!iContasAReceberRepository.existsById(codigo)) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(contasAReceberService.atualizarContas(contasReceberModel, codigo));
    }

    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o 204
    public ResponseEntity deletar(@PathVariable Long codigo) {
        if (!iContasAReceberRepository.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Id não encontrado");

        }
        contasAReceberService.deletarContasCadastradas(codigo);
        return null;
    }


}
