package com.example.gerenciamentoDeContas.controller;

import com.example.gerenciamentoDeContas.model.Dto.UsuarioModelDto;
import com.example.gerenciamentoDeContas.model.UsuarioModel;
import com.example.gerenciamentoDeContas.repository.IUsuarioRepository;
import com.example.gerenciamentoDeContas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Controller com o mapeamento e validated para validações existentes
@RestController
@Validated
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @PostMapping
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@Valid @RequestBody UsuarioModel usuarioModel) {
        UsuarioModel usuario = usuarioService.cadastrarNovoUsuario(usuarioModel);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModelDto>> exibirUsuariosCadastrados() {
        List<UsuarioModel> list = usuarioService.exibirUsuarioCadastrado();
        List<UsuarioModelDto> listUsuarioModel = list.stream().map(obj -> new UsuarioModelDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listUsuarioModel);
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Optional<UsuarioModel>> exibirUsuarioViaId(@PathVariable Long codigo) {
        return ResponseEntity.ok(usuarioService.exibirUsuarioViaId(codigo));
    }

    @PutMapping(path = "/{codigo}")
    public ResponseEntity<UsuarioModel> alterarContasCadastradas(@Valid @PathVariable Long codigo, @RequestBody UsuarioModel usuarioModel) {
        if (!iUsuarioRepository.existsById(codigo)) {
            return ResponseEntity.notFound().build(); // retorna 422
        }
        return ResponseEntity.ok(usuarioService.alterarUsuarioCadastrado(usuarioModel, codigo));
    }

    @DeleteMapping(path = "/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o 204
    public ResponseEntity deletar(@PathVariable Long codigo) {
        if (!iUsuarioRepository.existsById(codigo)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Id não encontrado");

        }
        usuarioService.deletarUsuario(codigo);
        return null;
    }


}
