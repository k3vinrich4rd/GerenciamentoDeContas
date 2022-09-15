package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.exception.SessaoDeEntidadeNaoEncotrada;
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

    public List<CidadeModel> exibirTodasAsCidades() {
        return iCidadeRepository.findAll();
    }

    public Optional<CidadeModel> exibirCidadeViaId(Long codigo) {
        return Optional.ofNullable(iCidadeRepository.findById(codigo).orElseThrow((() -> new SessaoDeEntidadeNaoEncotrada("Erro: id não encontrado, impossivel efetuar busca"))));
    }

    public CidadeModel alterarCidadeCadastrada(CidadeModel cidadeModel, Long codigo) {
        iCidadeRepository.findById(codigo).orElseThrow(() -> new SessaoDeEntidadeNaoEncotrada("Erro: id não encontrado, impossivel efetuar uma alteração"));
        return iCidadeRepository.save(cidadeModel);
    }

    public void deletarCidadesCadastradas(Long codigo) {
        iCidadeRepository.deleteById(codigo);
    }
}
