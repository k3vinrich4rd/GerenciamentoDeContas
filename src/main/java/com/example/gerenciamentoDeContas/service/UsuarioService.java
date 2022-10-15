package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.exception.EntityNotFoundException;
import com.example.gerenciamentoDeContas.model.Dto.UsuarioRequest;
import com.example.gerenciamentoDeContas.model.Dto.UsuarioResponse;
import com.example.gerenciamentoDeContas.model.UsuarioModel;
import com.example.gerenciamentoDeContas.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//Lógica e validações
public class UsuarioService {
    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    public UsuarioResponse cadastrarNovoUsuario(UsuarioRequest usuarioRequest) {
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNomeUsuario(usuarioRequest.getNomeUsuario());
        usuarioModel.setDataDeNascimento(usuarioRequest.getDataDeNascimento());
        usuarioModel.setEmail(usuarioRequest.getEmail());
        usuarioModel.setCpf(usuarioRequest.getCpf());
        iUsuarioRepository.save(usuarioModel);

        return new UsuarioResponse(usuarioRequest.getNomeUsuario(),
                usuarioRequest.getDataDeNascimento(),
                usuarioRequest.getEmail(),
                usuarioRequest.getDataDeNascimento());

    }

    public List<UsuarioResponse> exibirUsuarioCadastrado() {
        List<UsuarioModel> usuarioModelList = iUsuarioRepository.findAll();
        return usuarioModelList.stream().map(obj -> new UsuarioResponse(obj.getCodigo()
                ,obj.getNomeUsuario(), obj.getDataDeNascimento(), obj.getEmail())).collect(Collectors.toList());

    }


    public Optional<UsuarioModel> exibirUsuarioViaId(UUID codigo) {
        return Optional.ofNullable(iUsuarioRepository.findById(codigo).orElseThrow((() -> new EntityNotFoundException("Erro: id não encontrado, impossivel efetuar busca pelo id " + codigo))));
    }


    public UsuarioModel alterarUsuarioCadastrado(UsuarioModel usuarioModel, UUID codigo) {
        iUsuarioRepository.findById(codigo).orElseThrow(() -> new EntityNotFoundException("Erro: id não encontrado, impossivel efetuar uma alteração" + codigo));
        return iUsuarioRepository.save(usuarioModel);
    }

    public void deletarUsuario(UUID codigo) {
        if (!iUsuarioRepository.existsById(codigo)) {
            throw new RuntimeException("Erro, id não encontrado");
        }
        iUsuarioRepository.deleteById(codigo);
    }

    public boolean existsById(UUID codigo) {
        return iUsuarioRepository.existsById(codigo);
    }
}

