package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;
import com.example.gerenciamentoDeContas.repository.IContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContasAReceberService {


    @Autowired
    private IContasAReceberRepository iContasAReceberRepository;

    public ContasReceberModel cadastrarNovoRecebimento(ContasReceberModel contasReceberModel) {
        return iContasAReceberRepository.save(contasReceberModel);
    }

    public List<ContasReceberModel> exibirContas(){
        return iContasAReceberRepository.findAll();
    }

    public Optional<ContasReceberModel> exibirViaId(Long codigo) {
        return iContasAReceberRepository.findById(codigo);
    }

    public ContasReceberModel atualizarContas(ContasReceberModel contasReceberModel) {
        return iContasAReceberRepository.save(contasReceberModel);
    }

    public void deletarContasCadastradas(Long codigo) {
        iContasAReceberRepository.deleteById(codigo);
    }

}

