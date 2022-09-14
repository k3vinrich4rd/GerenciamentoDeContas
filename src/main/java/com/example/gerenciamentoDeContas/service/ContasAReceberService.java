package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import com.example.gerenciamentoDeContas.model.ContasReceberModel;
import com.example.gerenciamentoDeContas.model.recebimentos.CalculoRecebimentoFactory;
import com.example.gerenciamentoDeContas.model.request.AlterarStatusPagamentoRequest;
import com.example.gerenciamentoDeContas.model.response.ContasAReceberResponse;
import com.example.gerenciamentoDeContas.repository.IContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.gerenciamentoDeContas.enumeric.RecebimentoAlugueis.*;

@Service
public class ContasAReceberService {


    @Autowired
    private IContasAReceberRepository iContasAReceberRepository;

    public ContasReceberModel cadastrarNovoRecebimento(ContasReceberModel contasReceberModel) { // Setamento da status do recebimento
        Boolean recebimentoEmDia = LocalDate.now().isBefore(contasReceberModel.getDataDeVencimento()) || LocalDate.now().equals(contasReceberModel.getDataDeVencimento());
        if (Boolean.FALSE.equals(recebimentoEmDia)) {
            contasReceberModel.setRecebimentoAlugueis(EM_ATRASO);
        } else if (Boolean.TRUE.equals(recebimentoEmDia)) {
            contasReceberModel.setRecebimentoAlugueis(EM_DIA);
        } else {
            contasReceberModel.setRecebimentoAlugueis(ADIANTADO);
        }

        //Resultado do calculo da factory
        BigDecimal resultado = (BigDecimal) CalculoRecebimentoFactory.tipoDeRecebimentos(contasReceberModel.getRecebimentoAlugueis(), contasReceberModel.getTipoRecebimento());
        contasReceberModel.setValorRecebimento(resultado);
        return iContasAReceberRepository.save(contasReceberModel);
    }


    public List<ContasAReceberResponse> exibirTodosRecebimentos() {

        List<ContasAReceberResponse> contasAReceberResponse = new ArrayList<>();
        List<ContasReceberModel> contasReceberModelList = iContasAReceberRepository.findAll();
        for (ContasReceberModel valoresDeResposta : contasReceberModelList) {
            ContasAReceberResponse contasAReceber = new ContasAReceberResponse();
            contasAReceber.setCodigo(valoresDeResposta.getUsuarioModel().getCodigo());
            contasAReceber.setNomeUsuario(valoresDeResposta.getUsuarioModel().getNomeUsuario());
            contasAReceber.setEmail(valoresDeResposta.getUsuarioModel().getEmail());
            contasAReceber.setDataDeNascimento(valoresDeResposta.getUsuarioModel().getDataDeNascimento());

        }

        return contasAReceberResponse;
    }

    public Optional<ContasReceberModel> exibirViaId(Long codigo) {
        return iContasAReceberRepository.findById(codigo);
    }

    public ContasReceberModel atualizarContas(ContasReceberModel contasReceberModel, Long codigo) {
       ContasReceberModel contasReceber = iContasAReceberRepository.findById(codigo).get();
       contasReceber.setStatus(contasReceberModel.getStatus());
       contasReceber.setDataDeRecebimento(LocalDateTime.now());
        return iContasAReceberRepository.save(contasReceberModel);
    }

    public void deletarContasCadastradas(Long codigo) {
        iContasAReceberRepository.deleteById(codigo);
    }

}


