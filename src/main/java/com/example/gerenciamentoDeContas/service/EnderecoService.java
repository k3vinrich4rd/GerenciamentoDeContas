package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.EnderecoModel;
import com.example.gerenciamentoDeContas.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {


    @Autowired
    private IEnderecoRepository iEnderecoRepository;

    public EnderecoModel cadastrarNovosEnderecos(EnderecoModel enderecoModel) {
        return iEnderecoRepository.save(enderecoModel);
    }
    public List<EnderecoModel> exibirEnderecos(){
        return iEnderecoRepository.findAll();
    }

    public Optional<EnderecoModel> exibirEnderecoViaId(Long codigo) {
        return iEnderecoRepository.findById(codigo);
    }

    public EnderecoModel alterarEnderecoCadastrado(EnderecoModel enderecoModel) {
        return iEnderecoRepository.save(enderecoModel);
    }

    public void deletarEndereco(Long codigo) {
        iEnderecoRepository.deleteById(codigo);
    }
}
