package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.EnderecoModel;
import com.example.gerenciamentoDeContas.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
