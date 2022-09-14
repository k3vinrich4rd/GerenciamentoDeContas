package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.EstadoModel;
import com.example.gerenciamentoDeContas.repository.IEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {


    @Autowired
    private IEstadoRepository iEstadoRepository;

    public EstadoModel cadastrarEstados(EstadoModel estadoModel) {
        return iEstadoRepository.save(estadoModel);
    }

    public List<EstadoModel> exibirEstados() {
        return iEstadoRepository.findAll();
    }

    public Optional<EstadoModel> exibirEstadosViaId(Long codigo) {
        return iEstadoRepository.findById(codigo);
    }

    public EstadoModel alterarEstadosCadastrados(EstadoModel estadoModel) {
        return iEstadoRepository.save(estadoModel);
    }

    public void deletarEstados(Long codigo) {
        iEstadoRepository.deleteById(codigo);
    }
}
