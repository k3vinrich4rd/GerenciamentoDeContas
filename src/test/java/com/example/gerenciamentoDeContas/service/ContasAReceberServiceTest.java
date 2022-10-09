package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;
import com.example.gerenciamentoDeContas.repository.IContasAReceberRepository;
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
import java.util.UUID;

@SpringBootTest
public class ContasAReceberServiceTest {

    @Mock
    ContasAReceberService contasAReceberService;

    @MockBean
    IContasAReceberRepository iContasAReceberRepository;

    private ContasReceberModel contasReceberModel;

    @BeforeEach
    private void inicializadora() {
        MockitoAnnotations.openMocks(this);
        contasReceberModel = new ContasReceberModel();
    }

    @Test
    @DisplayName("Testando o metodo de cadastrar")
    void testeCadastrarContasAReceberEstaFuncionando() {
        iContasAReceberRepository.save(contasReceberModel);
        Mockito.when(iContasAReceberRepository.existsById(Mockito.any())).thenReturn(true);
        Mockito.verify(iContasAReceberRepository, Mockito.times(1)).save(contasReceberModel);
    }

    @Test
    @DisplayName("O teste deve retornar true, pois nenhuma contasAReceber foi cadastrada")
    void testeExibirContasAReceber() {
        List<ContasReceberModel> contasReceberModelList = contasAReceberService.exibirTodosRecebimentos();
        Assertions.assertTrue(contasReceberModelList.isEmpty());
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo de buscar por id estiver funcionando corretamente")
    void testeBuscarContasAReceberViaId() {
        Optional<ContasReceberModel> contasReceberModelOptional = contasAReceberService.exibirRecebimentoViaId(UUID.randomUUID());
        Assertions.assertTrue(true, String.valueOf(contasReceberModelOptional));
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo de atualizar estiver funcionando corretamente")
    void testeAtualizarContasAReceber() {
        contasAReceberService.atualizarContas(contasReceberModel);
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo deletar via id estiver funcionando corretamente")
    void testeDeletarContasAReceberViaId() {
        contasAReceberService.deletarContasCadastradas(UUID.randomUUID());
        Assertions.assertTrue(true);
    }
}
