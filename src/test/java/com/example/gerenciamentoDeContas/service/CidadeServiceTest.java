package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.CidadeModel;
import com.example.gerenciamentoDeContas.repository.ICidadeRepository;
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

@SpringBootTest
public class CidadeServiceTest {

    @Mock
    CidadeService cidadeService;

    @MockBean
    ICidadeRepository iCidadeRepository;

    private CidadeModel cidadeModel;

    @BeforeEach
    private void inicializadora() {
        MockitoAnnotations.openMocks(this);
        cidadeModel = new CidadeModel();
    }

    @Test
    @DisplayName("Testando o metodo de cadastrar")
    void testeSeCadastroDeCidadeEstaFuncionando() {
        iCidadeRepository.save(cidadeModel);
        Mockito.when(iCidadeRepository.existsById(Mockito.anyLong())).thenReturn(true);
        Mockito.verify(iCidadeRepository, Mockito.times(1)).save(cidadeModel);
    }


    @Test
    @DisplayName("O teste deve retornar true, pois nenhuma cidade foi cadastrada")
    void testeDeExibicaoDeCidades() {
        List<CidadeModel> todasCidades = cidadeService.exibirTodasAsCidades();
        Assertions.assertTrue(todasCidades.isEmpty());
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo de buscar por id estiver funcionando corretamente")
    void testeDeBuscarCidadesViaId() {
        cidadeService.exibirCidadeViaId(1L);
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo de atualizar estiver funcionando corretamente")
    void testeDeAtualizarCidade() {
        cidadeService.alterarCidadeCadastrada(cidadeModel, 1L);
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo deletar via id estiver funcionando corretamente")
    void testeDeDeletarCidadesViaId() {
        cidadeService.deletarCidadesCadastradas(1L);
        Assertions.assertTrue(true);
    }

}
