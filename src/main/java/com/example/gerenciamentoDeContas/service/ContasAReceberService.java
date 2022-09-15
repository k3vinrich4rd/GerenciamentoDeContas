package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.exception.SessaoDeEntidadeNaoEncotrada;
import com.example.gerenciamentoDeContas.model.ContasReceberModel;
import com.example.gerenciamentoDeContas.model.recebimentos.CalculoRecebimentoFactory;
import com.example.gerenciamentoDeContas.repository.IContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.gerenciamentoDeContas.enumeric.RecebimentoAlugueis.*;

@Service
public class ContasAReceberService {


    @Autowired
    private IContasAReceberRepository iContasAReceberRepository;

    public ContasReceberModel cadastrarNovoRecebimento(ContasReceberModel contasReceberModel) { // Setamento da status do recebimento
//        Boolean recebimentoEmDia = LocalDate.now().isBefore(contasReceberModel.getDataDeVencimento()) || LocalDate.now().equals(contasReceberModel.getDataDeVencimento());
        if (contasReceberModel.getDataDeVencimento().isBefore(LocalDate.now())) {
            contasReceberModel.setRecebimentoAlugueis(EM_ATRASO);
        } else if (contasReceberModel.getDataDeVencimento().isEqual(LocalDate.now())) { //isEqual Para horário
            contasReceberModel.setRecebimentoAlugueis(EM_DIA);
        } else if (contasReceberModel.getDataDeVencimento().isAfter(LocalDate.now())) {
            contasReceberModel.setRecebimentoAlugueis(ADIANTADO);
        } else {
            return null;
        }

        if (contasReceberModel.getStatus().equalsIgnoreCase("pago")) {
            contasReceberModel.setDataDeRecebimento(LocalDateTime.now());
        }

        BigDecimal resposta = (BigDecimal) CalculoRecebimentoFactory.tipoDeRecebimentos(contasReceberModel.getRecebimentoAlugueis(),
                contasReceberModel.getTipoRecebimento()).calculoDeRecebimentos(contasReceberModel);
        contasReceberModel.setValorRecebimento(resposta);
        return iContasAReceberRepository.save(contasReceberModel);
    }


    public List<ContasReceberModel> exibirTodosRecebimentos() {
        return iContasAReceberRepository.findAll();

    }

    public Optional<ContasReceberModel> exibirRecebimentoViaId(Long codigo) {
        return Optional.ofNullable(iContasAReceberRepository.findById(codigo).orElseThrow((() -> new SessaoDeEntidadeNaoEncotrada("Erro: id não encontrado" + codigo))));
    }

    public ContasReceberModel atualizarContas(ContasReceberModel contasReceberModel) {
        if (contasReceberModel.getStatus().equalsIgnoreCase("pago")) {
            contasReceberModel.setDataDeRecebimento(LocalDateTime.now());
        }
        return iContasAReceberRepository.save(contasReceberModel);
    }

    public void deletarContasCadastradas(Long codigo) {
        iContasAReceberRepository.deleteById(codigo);
    }

}


