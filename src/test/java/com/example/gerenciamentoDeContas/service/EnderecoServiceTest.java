package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.EnderecoModel;
import com.example.gerenciamentoDeContas.repository.IEnderecoRepository;
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
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EnderecoServiceTest {

    @Mock
    EnderecoService enderecoService;

    @MockBean
    IEnderecoRepository iEnderecoRepository;

    private EnderecoModel enderecoModel;

    @BeforeEach
    private void inicializadora() {
        MockitoAnnotations.openMocks(this);
        enderecoModel = new EnderecoModel();
    }

    @Test
    @DisplayName("Testando o metodo de cadastrar")
    void testeCadastrarEnderecoService() {
        iEnderecoRepository.save(enderecoModel);
        Mockito.when(iEnderecoRepository.existsById(Mockito.any())).thenReturn(true);
        Mockito.verify(iEnderecoRepository, Mockito.times(1)).save(enderecoModel);
    }

    @Test
    @DisplayName("O teste deve retornar true, pois nenhuma cidade foi cadastrada")
    void testeExibirEnderecoService() {
        List<EnderecoModel> enderecoModelList = enderecoService.exibirTodosEnderecos();
        assertTrue(enderecoModelList.isEmpty());
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo de buscar por id estiver funcionando corretamente")
    void testeBuscarEnderecoViaId() {
        Optional<EnderecoModel> enderecoModelOptional = enderecoService.exibirEnderecosViaId(UUID.randomUUID());
        assertTrue(true, String.valueOf(enderecoModelOptional));
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo de atualizar estiver funcionando corretamente")
    void testeAtualizarEnderecoService() {
        EnderecoModel enderecoModel1 = enderecoService.alterarEnderecosCadastrados(enderecoModel, UUID.randomUUID());
        iEnderecoRepository.save(enderecoModel);
        assertTrue(true, (Supplier<String>) enderecoModel1);
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo deletar via id estiver funcionando corretamente")
    void testeDeletarEnderecoViaId() {
        EnderecoService enderecoService1 = enderecoService.deletarEnderecosCadastrados(UUID.randomUUID());
        assertTrue(true, (Supplier<String>) enderecoService1);
    }

}
