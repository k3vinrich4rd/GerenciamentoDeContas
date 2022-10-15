package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.model.Dto.UsuarioRequest;
import com.example.gerenciamentoDeContas.model.Dto.UsuarioResponse;
import com.example.gerenciamentoDeContas.model.UsuarioModel;
import com.example.gerenciamentoDeContas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Controller com o mapeamento e validated para validações existentes
@RestController
@Validated
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarNovoUsuario(usuarioRequest));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> exibirUsuariosCadastrados() {
        return ResponseEntity.ok().body(usuarioService.exibirUsuarioCadastrado());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<UsuarioModel>> exibirUsuarioViaId(@PathVariable UUID codigo) {
        return ResponseEntity.ok(usuarioService.exibirUsuarioViaId(codigo));
    }

    @PutMapping(path = "/{codigo}")
    public ResponseEntity<UsuarioModel> alterarContasCadastradas(@Valid @PathVariable UUID codigo, @RequestBody UsuarioModel usuarioModel) {
        if (!usuarioService.existsById(codigo)) {
            return ResponseEntity.notFound().build(); // retorna 404
        }
        return ResponseEntity.ok(usuarioService.alterarUsuarioCadastrado(usuarioModel, codigo));
    }

    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NOT_FOUND) // Retorna o 204
    public void deletar(@PathVariable UUID codigo) {
        usuarioService.deletarUsuario(codigo);
    }


}
