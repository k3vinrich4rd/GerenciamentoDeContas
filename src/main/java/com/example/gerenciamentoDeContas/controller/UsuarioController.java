package com.example.gerenciamentoDeContas.controller;

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

@RestController
@Validated
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@Valid @RequestBody UsuarioModel usuarioModel) {
        UsuarioModel usuario = usuarioService.cadastrarNovoUsuario(usuarioModel);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> exibirUsuariosCadastrados(){
        return ResponseEntity.ok(usuarioService.exibirUsuarioCadastrado());
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<UsuarioModel>> exibirUsuarioViaId(@PathVariable Long codigo){
        return ResponseEntity.ok(usuarioService.exibirUsuarioViaId(codigo));
    }

    @PutMapping(path = "/{codigo}")
    public ResponseEntity<UsuarioModel> alterarUsuarioCadastrado(@Valid @RequestBody UsuarioModel usuarioModel){
        return ResponseEntity.ok(usuarioService.alterarUsuarioCadastrado(usuarioModel));
    }

    @DeleteMapping(path = "/{codigo}")
    public void deletarUsuarioCadastrado(@PathVariable Long codigo){
        usuarioService.deletarUsuario(codigo);
    }


}
