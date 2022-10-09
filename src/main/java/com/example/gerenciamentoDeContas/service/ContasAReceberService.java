package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.enumeric.TipoRecebimento;
import com.example.gerenciamentoDeContas.exception.EntityNotFoundException;
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
import java.util.UUID;

import static com.example.gerenciamentoDeContas.enumeric.RecebimentoAlugueis.*;

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

        if (contasReceberModel.getStatus().equalsIgnoreCase("pago")) {
            contasReceberModel.setDataDeRecebimento(LocalDateTime.now());
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

    public Optional<ContasReceberModel> exibirRecebimentoViaId(UUID codigo) {
        return Optional.ofNullable(iContasAReceberRepository.findById(codigo).orElseThrow((() -> new EntityNotFoundException("Erro: id não encontrado" + codigo))));
    }

    //Lógica criada para setar a hora do pagamento quando o usuário informar "pago"
    public ContasReceberModel atualizarContas(ContasReceberModel contasReceberModel) {
        if (contasReceberModel.getStatus().equalsIgnoreCase("pago")) {
            contasReceberModel.setDataDeRecebimento(LocalDateTime.now());
        }
        return iContasAReceberRepository.save(contasReceberModel);
    }

    public void deletarContasCadastradas(UUID codigo) {
        iContasAReceberRepository.deleteById(codigo);
    }

    public boolean existsById(UUID codigo) {
        return iContasAReceberRepository.existsById(codigo);
    }

    public List<ContasReceberModel> exibirViaDataDeVencimento(String dataDeVencimento) {
        LocalDate date = LocalDate.parse(dataDeVencimento);
        return iContasAReceberRepository.findByDataDeVencimento(date);
    }

    public List<ContasReceberModel> exibirStatusContasAReceber(String status) {
        return iContasAReceberRepository.findByStatus(status);
    }

    public List<ContasReceberModel> exibirViaTipoRecebimento(TipoRecebimento tipoRecebimento) {
        return iContasAReceberRepository.findByTipoRecebimento(tipoRecebimento);
    }
}




