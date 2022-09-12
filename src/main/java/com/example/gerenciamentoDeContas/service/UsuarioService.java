package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.UsuarioModel;
import com.example.gerenciamentoDeContas.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    public UsuarioModel cadastrarNovoUsuario(UsuarioModel usuarioModel) {
        return iUsuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> exibirUsuarioCadastrado() {
        return iUsuarioRepository.findAll();
    }


    public Optional<UsuarioModel> exibirUsuarioViaId(Long id) {
        return iUsuarioRepository.findById(id);
    }


    public UsuarioModel alterarUsuarioCadastrado(UsuarioModel usuarioModel) {
        return iUsuarioRepository.save(usuarioModel);
    }

    public void deletarUsuario(Long id) {
        iUsuarioRepository.deleteById(id);
    }
}
