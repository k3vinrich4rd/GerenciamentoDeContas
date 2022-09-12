package com.example.gerenciamentoDeContas.service;
// Caso estiver assim, não precisará repetir a escrita do Enum

import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import com.example.gerenciamentoDeContas.model.request.AlterarStatusPagamentoRequest;
import com.example.gerenciamentoDeContas.model.response.ContasAPagarResponse;
import com.example.gerenciamentoDeContas.repository.IContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.gerenciamentoDeContas.enumeric.Status.AGUARDANDO;
import static com.example.gerenciamentoDeContas.enumeric.Status.VENCIDA;

@Service //Lógica do código
public class ContasAPagarService {

    @Autowired
    private IContasAPagarRepository contasAPagarRepository;

    public ContasAPagarModel cadastrarContas(ContasAPagarModel contasAPagarModel) {
        Boolean pagamentoEmDia = LocalDate.now().isBefore(contasAPagarModel.getDataDeVencimento()) || LocalDate.now().equals(contasAPagarModel.getDataDeVencimento());
        if (Boolean.FALSE.equals(pagamentoEmDia)) {
            contasAPagarModel.setStatus(VENCIDA);
        } else {
            contasAPagarModel.setStatus(AGUARDANDO);
        }
        return contasAPagarRepository.save(contasAPagarModel);
    }


    public List<ContasAPagarResponse> exibirTodosRegistrosDePagamento() {

        List<ContasAPagarResponse> contasAPagarResposta = new ArrayList<>();
        List<ContasAPagarModel> contasAPagarModelList = contasAPagarRepository.findAll();
        for (ContasAPagarModel valoresDeResposta : contasAPagarModelList) {
            ContasAPagarResponse contasAPagar = new ContasAPagarResponse();
            contasAPagar.setId(valoresDeResposta.getId());
            contasAPagar.setNome(valoresDeResposta.getNome());
            contasAPagar.setValor(valoresDeResposta.getValor());
            contasAPagar.setStatus(valoresDeResposta.getStatus());
            contasAPagarResposta.add(contasAPagar);
        }
        return contasAPagarResposta;
    }


    public Optional<ContasAPagarModel> exibirContasViaId(Long id) {
        return contasAPagarRepository.findById(id);
    }

    public ContasAPagarModel alterarRegistrosDePagamento(AlterarStatusPagamentoRequest alterarStatusPagamentoRequest, Long id) {
        ContasAPagarModel contasAPagar = contasAPagarRepository.findById(id).get(); // Transforma em um objeto comum
        contasAPagar.setStatus(alterarStatusPagamentoRequest.getStatus());
        contasAPagar.setDataDePagamento(LocalDateTime.now());

        return contasAPagarRepository.save(contasAPagar);

    }

    public void deletarConta(Long id) {
        contasAPagarRepository.deleteById(id);
    }
}









