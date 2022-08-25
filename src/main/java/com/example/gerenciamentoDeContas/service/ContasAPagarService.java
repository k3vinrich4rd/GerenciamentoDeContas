package com.example.gerenciamentoDeContas.service;
// Caso estiver assim, não precisará repetir a escrita do Enum

import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import com.example.gerenciamentoDeContas.repository.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.gerenciamentoDeContas.enumeric.Status.AGUARDANDO;
import static com.example.gerenciamentoDeContas.enumeric.Status.VENCIDA;

@Service
public class ContasAPagarService {


    @Autowired
    private ContasAPagarRepository contasAPagarRepository;

    public ContasAPagarModel cadastrarContas(ContasAPagarModel contasAPagarModel) {
        Boolean pagamentoEmDia = LocalDate.now().isAfter(contasAPagarModel.getDataDeVencimento());
        // Possível mudança, perguntar para a grazi
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


    public void deletarRegistros(Long id) {
        contasAPagarRepository.deleteById(id);
    }


    // contasAPagarModel.setDataDePagamento(LocalDateTime.now());
}


