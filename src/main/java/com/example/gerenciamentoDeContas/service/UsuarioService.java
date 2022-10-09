package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.exception.EntityNotFoundException;
import com.example.gerenciamentoDeContas.model.UsuarioModel;
import com.example.gerenciamentoDeContas.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
//Lógica e validações
public class UsuarioService {


    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    public UsuarioModel cadastrarNovoUsuario(UsuarioModel usuarioModel) {
        return iUsuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> exibirUsuarioCadastrado() {
        return iUsuarioRepository.findAll();
    }


    public Optional<UsuarioModel> exibirUsuarioViaId(UUID codigo) {
        return Optional.ofNullable(iUsuarioRepository.findById(codigo).orElseThrow((() -> new EntityNotFoundException("Erro: id não encontrado, impossivel efetuar busca pelo id " + codigo))));
    }


    public UsuarioModel alterarUsuarioCadastrado(UsuarioModel usuarioModel, UUID codigo) {
        iUsuarioRepository.findById(codigo).orElseThrow(() -> new EntityNotFoundException("Erro: id não encontrado, impossivel efetuar uma alteração" + codigo));
        return iUsuarioRepository.save(usuarioModel);
    }

    public void deletarUsuario(UUID codigo) {
        iUsuarioRepository.deleteById(codigo);
    }

    public boolean existsById(UUID codigo) {
        return iUsuarioRepository.existsById(codigo);
    }
}
