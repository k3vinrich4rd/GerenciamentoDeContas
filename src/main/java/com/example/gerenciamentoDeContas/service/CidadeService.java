package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.CidadeModel;
import com.example.gerenciamentoDeContas.repository.ICidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {


    @Autowired
    private ICidadeRepository iCidadeRepository;

    public CidadeModel cadastrarCidade(CidadeModel cidadeModel) {
        return iCidadeRepository.save(cidadeModel);
    }

    public List<CidadeModel> exibirCidades() {
        return iCidadeRepository.findAll();
    }

    public Optional<CidadeModel> exibirCidadesViaId(Long id) {
        return iCidadeRepository.findById(id);
    }

    public CidadeModel alterarCidadesCadastradas(CidadeModel cidadeModel) {
        return iCidadeRepository.save(cidadeModel);
    }

    public void deletarCidadesCadastradas(Long id) {
        iCidadeRepository.deleteById(id);
    }
}
