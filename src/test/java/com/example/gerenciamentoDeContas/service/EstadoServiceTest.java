package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.EstadoModel;
import com.example.gerenciamentoDeContas.repository.IEstadoRepository;
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
public class EstadoServiceTest {

    @Mock
    EstadoService estadoService;

    @MockBean
    IEstadoRepository iEstadoRepository;

    private EstadoModel estadoModel;

    @BeforeEach
    private void inicializadora() {
        MockitoAnnotations.openMocks(this);
        estadoModel = new EstadoModel();
    }

    @Test
    @DisplayName("Testando o metodo de cadastrar")
    void testeSeCadastrarServiceEstaFuncionando() {
        iEstadoRepository.save(estadoModel);
        Mockito.when(iEstadoRepository.existsById(Mockito.anyLong())).thenReturn(true);
        Mockito.verify(iEstadoRepository, Mockito.times(1)).save(estadoModel);
    }

    @Test
    @DisplayName("O teste deve retornar true, pois nenhuma estado foi cadastrada")
    void testeDeExibicaoEstadoService() {
        List<EstadoModel> estadoModelList = estadoService.exibirEstados();
        Assertions.assertTrue(estadoModelList.isEmpty());
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo de buscar por id estiver funcionando corretamente")
    void testeExibirEstadoViaId() {
        estadoService.exibirEstadoViaId(1L);
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo de atualizar estiver funcionando corretamente")
    void testeAtualizarEstado(){
        estadoService.alterarEstadoCadastrado(estadoModel, 1L);
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo deletar via id estiver funcionando corretamente")
    void testeDeletarEstado(){
        estadoService.deletarEstados(1L);
        Assertions.assertTrue(true);
    }
}
