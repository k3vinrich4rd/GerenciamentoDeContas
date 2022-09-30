package com.example.gerenciamentoDeContas.exception;

//Classe de feita para tratar mensagens não encontradas
public class SessaoDeEntidadeNaoEncontrada extends RuntimeException {
    public SessaoDeEntidadeNaoEncontrada(String msg) { // Tratamento de erro
        super(msg);
    }
}
