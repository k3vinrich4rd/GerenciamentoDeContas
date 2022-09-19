package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.exception.SessaoDeEntidadeNaoEncotrada;
import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import com.example.gerenciamentoDeContas.model.ContasReceberModel;
import com.example.gerenciamentoDeContas.model.recebimentosfactory.CalculoRecebimentoFactory;
import com.example.gerenciamentoDeContas.repository.IContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.gerenciamentoDeContas.enumeric.RecebimentoAlugueis.*;
import static com.example.gerenciamentoDeContas.enumeric.Status.AGUARDANDO;
import static com.example.gerenciamentoDeContas.enumeric.Status.VENCIDA;

@Service
public class ContasAReceberService {


    @Autowired
    private IContasAReceberRepository iContasAReceberRepository;

    public ContasReceberModel cadastrarNovoRecebimento(ContasReceberModel contasReceberModel) { // Setamento da status do recebimento
        if (contasReceberModel.getDataDeVencimento().isBefore(LocalDate.now())) { // Se a data de vencimento for antes do pagamento (que no caso é hoje)
            contasReceberModel.setRecebimentoAlugueis(EM_ATRASO); //Retorna em atraso
        } else if (contasReceberModel.getDataDeVencimento().isEqual(LocalDate.now())) { // Se a data de vencimento e pagamento for hoje (//isEqual Para horário)
            contasReceberModel.setRecebimentoAlugueis(EM_DIA); //Retorna em dia
        } else if (contasReceberModel.getDataDeVencimento().isAfter(LocalDate.now())) { //Se a data de vencimento for depois do pagamento
            contasReceberModel.setRecebimentoAlugueis(ADIANTADO); //Retorna adiantado
        } else {
            return null;
        }


        //Conexão com a factory
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

    //Lógica criada para setar a hora do pagamento quando o usuário informar "pago"
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


