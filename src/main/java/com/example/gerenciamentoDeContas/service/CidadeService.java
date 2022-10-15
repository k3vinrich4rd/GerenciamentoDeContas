package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.exception.EntityNotFoundException;
import com.example.gerenciamentoDeContas.model.CidadeModel;
import com.example.gerenciamentoDeContas.repository.ICidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<CidadeModel> exibirCidadeViaId(UUID codigo) {
        return Optional.ofNullable(iCidadeRepository.findById(codigo).orElseThrow((() -> new EntityNotFoundException("Erro: id não encontrado, impossivel efetuar busca " + codigo))));
    }

    public CidadeModel alterarCidadeCadastrada(CidadeModel cidadeModel, UUID codigo) {
        iCidadeRepository.findById(codigo).orElseThrow(() -> new EntityNotFoundException("Erro: id não encontrado, impossivel efetuar uma alteração " + codigo));
        return iCidadeRepository.save(cidadeModel);
    }

    public void deletarCidadesCadastradas(UUID codigo) {
        if (!iCidadeRepository.existsById(codigo)) {
            throw new RuntimeException("Erro, id não encontrado");
        }
        iCidadeRepository.deleteById(codigo);
    }


    public boolean existsById(UUID codigo) {
        return iCidadeRepository.existsById(codigo);
    }
}
