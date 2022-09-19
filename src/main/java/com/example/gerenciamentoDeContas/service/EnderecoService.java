package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.exception.SessaoDeEntidadeNaoEncotrada;
import com.example.gerenciamentoDeContas.model.EnderecoModel;
import com.example.gerenciamentoDeContas.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<EnderecoModel> exibirEnderecosViaId(Long codigo) {
        return Optional.ofNullable(iEnderecoRepository.findById(codigo).orElseThrow((() -> new SessaoDeEntidadeNaoEncotrada("Erro: id não encontrado, impossivel efetuar busca" + codigo))));
    }

    public EnderecoModel alterarEnderecosCadastrados(EnderecoModel enderecoModel, Long codigo) {
        iEnderecoRepository.findById(codigo).orElseThrow(() -> new SessaoDeEntidadeNaoEncotrada("Erro: id não encontrado, impossivel efetuar uma alteração" + codigo));
        return iEnderecoRepository.save(enderecoModel);
    }

    public void deletarEnderecosCadastrados(Long codigo) {
        iEnderecoRepository.deleteById(codigo);
    }
}
