package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.exception.SessaoDeEntidadeNaoEncotrada;
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


    public Optional<UsuarioModel> exibirUsuarioViaId(Long codigo) {
        return Optional.ofNullable(iUsuarioRepository.findById(codigo).orElseThrow((() -> new SessaoDeEntidadeNaoEncotrada("Erro: id não encontrado, impossivel efetuar busca"))));
    }


    public UsuarioModel alterarUsuarioCadastrado(UsuarioModel usuarioModel, Long codigo) {
        iUsuarioRepository.findById(codigo).orElseThrow(() -> new SessaoDeEntidadeNaoEncotrada("Erro: id não encontrado, impossivel efetuar uma alteração"));
        return iUsuarioRepository.save(usuarioModel);
    }

    public void deletarUsuario(Long codigo) {
        iUsuarioRepository.deleteById(codigo);
    }
}
