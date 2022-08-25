package com.example.gerenciamentoDeContas.service;

import static com.example.gerenciamentoDeContas.enumeric.Status.*; // Caso estiver assim, não precisará repetir a escrita

import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import com.example.gerenciamentoDeContas.repository.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContasAPagarService {

    @Autowired
    private ContasAPagarRepository contasAPagarRepository;

    public ContasAPagarModel cadastrarContas(ContasAPagarModel contasAPagarModel) {
        Boolean pagamentoEmDia = LocalDate.now().isBefore(contasAPagarModel.getDataDeVencimento());
        if (Boolean.FALSE.equals(pagamentoEmDia)) {
            contasAPagarModel.setStatus(VENCIDA);
        } else {
            contasAPagarModel.setStatus(AGUARDANDO);

        }
        return contasAPagarRepository.save(contasAPagarModel);
    }

    public List<ContasAPagarModel> exibirTodosRegistrosDePagamento() {
        return contasAPagarRepository.findAll();
    }

    public Optional<ContasAPagarModel> exibirContasViaId(Long id) {
        return contasAPagarRepository.findById(id);
    }


    // contasAPagarModel.setDataDePagamento(LocalDateTime.now());
}


