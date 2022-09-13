package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.enumeric.RecebimentoAlugueis;
import com.example.gerenciamentoDeContas.model.ContasReceberModel;
import com.example.gerenciamentoDeContas.repository.IContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.gerenciamentoDeContas.enumeric.RecebimentoAlugueis.*;

@Service
public class ContasAReceberService {


    @Autowired
    private IContasAReceberRepository iContasAReceberRepository;

    public ContasReceberModel cadastrarNovoRecebimento(ContasReceberModel contasReceberModel) {
        Boolean recebimentoEmDia = LocalDate.now().isBefore(contasReceberModel.getDataDeVencimento()) || LocalDate.now().equals(contasReceberModel.getDataDeVencimento());
        if (Boolean.FALSE.equals(recebimentoEmDia)) {
            contasReceberModel.setRecebimentoAlugueis(EM_ATRASO) ;
        } else if (Boolean.TRUE.equals(recebimentoEmDia)) {
            contasReceberModel.setRecebimentoAlugueis(EM_DIA);
        } else {
            contasReceberModel.setRecebimentoAlugueis(ADIANTADO);
        }
        return iContasAReceberRepository.save(contasReceberModel);
    }

    public List<ContasReceberModel> exibirContas() {
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

