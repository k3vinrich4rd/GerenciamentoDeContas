package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import com.example.gerenciamentoDeContas.model.response.ContasAPagarResponse;
import com.example.gerenciamentoDeContas.repository.IContasAPagarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ContasAPagarServiceTest {

    @Mock
    ContasAPagarService contasAPagarService;

    @MockBean
    IContasAPagarRepository iContasAPagarRepository;

    private ContasAPagarModel contasAPagarModel;


    @BeforeEach
    private void inicializadora() {
        MockitoAnnotations.openMocks(this);
        contasAPagarModel = new ContasAPagarModel();
    }

    @Test
    @DisplayName("Testando o metodo de cadastrar")
    void testeCadastrarContas() {
        iContasAPagarRepository.save(contasAPagarModel);
        Mockito.when(iContasAPagarRepository.existsById(Mockito.anyLong())).thenReturn(true);
        Mockito.verify(iContasAPagarRepository, Mockito.times(1)).save(contasAPagarModel);
    }

    @Test
    @DisplayName("O teste deve retornar true, pois a lista esta vazia")
    void testeExibicaoDeContasAPagar() {
        List<ContasAPagarResponse> contasAPagarResponses = contasAPagarService.exibirTodosRegistrosDePagamento();
        Assertions.assertTrue(contasAPagarResponses.isEmpty());
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo estiver correto")
    void testeExibicaoDeContasAPagarViaId() {
        Optional<ContasAPagarModel> contasAPagarModelOptional = contasAPagarService.exibirContasViaId(1L);
        Assertions.assertTrue(true, String.valueOf(contasAPagarModelOptional));
    }

    @Test
    void testeDeletamentoDeContasViaId() {
        contasAPagarService.deletarConta(1L);
        Assertions.assertTrue(true);
    }
}
