package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.UsuarioModel;
import com.example.gerenciamentoDeContas.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
