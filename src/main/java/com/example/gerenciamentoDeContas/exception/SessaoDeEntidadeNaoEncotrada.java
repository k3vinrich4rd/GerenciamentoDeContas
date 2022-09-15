package com.example.gerenciamentoDeContas.exception;

public class SessaoDeEntidadeNaoEncotrada extends RuntimeException {
    public SessaoDeEntidadeNaoEncotrada(String msg) { // Tratamento de erro
        super(msg);
    }
}
