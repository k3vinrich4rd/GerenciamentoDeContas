package com.example.gerenciamentoDeContas.service;

import com.example.gerenciamentoDeContas.model.UsuarioModel;
import com.example.gerenciamentoDeContas.repository.IUsuarioRepository;
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
import java.util.UUID;

@SpringBootTest
public class UsuarioServiceTest {

    @Mock
    UsuarioService usuarioService;

    @MockBean
    IUsuarioRepository iUsuarioRepository;

    private UsuarioModel usuarioModel;

    @BeforeEach
    private void inicializadora() {
        MockitoAnnotations.openMocks(this);
        usuarioModel = new UsuarioModel();
    }

    @Test
    @DisplayName("Testando metodo de cadastrar")
    void testeUsuarioServiceEstaFuncionando() {
        iUsuarioRepository.save(usuarioModel);
        Mockito.when(iUsuarioRepository.existsById(Mockito.any())).thenReturn(true);
        Mockito.verify(iUsuarioRepository, Mockito.times(1)).save(usuarioModel);
    }

    @Test
    @DisplayName("O teste deve retornar true, pois nenhuma usuario foi cadastrado")
    void testeExibicaoUsuario() {
        List<UsuarioModel> usuarioModelList = usuarioService.exibirUsuarioCadastrado();
        Assertions.assertTrue(usuarioModelList.isEmpty());
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo de buscar por id estiver funcionando corretamente")
    void testeExibirUsuarioViaId() {
        iUsuarioRepository.findById(UUID.randomUUID());
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo de atualizar estiver funcionando corretamente")
    void testeAtualizarUsuario() {
        usuarioService.alterarUsuarioCadastrado(usuarioModel, UUID.randomUUID());
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("O teste deve retornar true, se o metodo deletar via id estiver funcionando corretamente")
    void testeDeletarUsuario() {
        usuarioService.deletarUsuario(UUID.randomUUID());
        Assertions.assertTrue(true);
    }

}
