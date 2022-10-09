package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.exception.EntityNotFoundException;
import com.example.gerenciamentoDeContas.model.EnderecoModel;
import com.example.gerenciamentoDeContas.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
//Lógica e validações
public class EnderecoService {

    @Autowired
    private IEnderecoRepository iEnderecoRepository;

    public EnderecoModel cadastrarEndereco(EnderecoModel enderecoModel) {
        return iEnderecoRepository.save(enderecoModel);
    }

    public List<EnderecoModel> exibirTodosEnderecos() {
        return iEnderecoRepository.findAll();
    }

    public Optional<EnderecoModel> exibirEnderecosViaId(UUID codigo) {
        return Optional.ofNullable(iEnderecoRepository.findById(codigo).orElseThrow((() -> new EntityNotFoundException("Erro: id não encontrado, impossivel efetuar busca" + codigo))));
    }

    public EnderecoModel alterarEnderecosCadastrados(EnderecoModel enderecoModel, UUID codigo) {
        iEnderecoRepository.findById(codigo).orElseThrow(() -> new EntityNotFoundException("Erro: id não encontrado, impossivel efetuar uma alteração" + codigo));
        return iEnderecoRepository.save(enderecoModel);
    }

    public EnderecoService deletarEnderecosCadastrados(UUID codigo) {
        iEnderecoRepository.deleteById(codigo);
        return null;
    }

    public boolean existsById(UUID codigo) {
        return iEnderecoRepository.existsById(codigo);
    }
}
