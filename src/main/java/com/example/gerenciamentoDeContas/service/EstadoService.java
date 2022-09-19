package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.exception.SessaoDeEntidadeNaoEncotrada;
import com.example.gerenciamentoDeContas.model.EstadoModel;
import com.example.gerenciamentoDeContas.repository.IEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//Lógica e validações
public class EstadoService {


    @Autowired
    private IEstadoRepository iEstadoRepository;

    public EstadoModel cadastrarEstados(EstadoModel estadoModel) {
        return iEstadoRepository.save(estadoModel);
    }

    public List<EstadoModel> exibirEstados() {
        return iEstadoRepository.findAll();
    }

    public Optional<EstadoModel> exibirEstadoViaId(Long codigo) {
        return Optional.ofNullable(iEstadoRepository.findById(codigo).orElseThrow((() -> new SessaoDeEntidadeNaoEncotrada("Erro: id não encontrado, impossivel efetuar busca" + codigo))));
    }

    public EstadoModel alterarEstadoCadastrado(EstadoModel estadoModel, Long codigo) {
        iEstadoRepository.findById(codigo).orElseThrow(() -> new SessaoDeEntidadeNaoEncotrada("Erro: id não encontrado, impossivel efetuar uma alteração" + codigo));
        return iEstadoRepository.save(estadoModel);
    }

    public void deletarEstados(Long codigo) {
        iEstadoRepository.deleteById(codigo);
    }
}
