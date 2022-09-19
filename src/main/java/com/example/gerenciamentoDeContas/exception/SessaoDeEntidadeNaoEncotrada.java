package com.example.gerenciamentoDeContas.exception;

//Classe de feita para tratar mensagens não encontradas
public class SessaoDeEntidadeNaoEncotrada extends RuntimeException {
    public SessaoDeEntidadeNaoEncotrada(String msg) { // Tratamento de erro
        super(msg);
    }
}
