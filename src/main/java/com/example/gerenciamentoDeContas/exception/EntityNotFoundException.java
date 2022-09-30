package com.example.gerenciamentoDeContas.exception;

//Classe de feita para tratar mensagens não encontradas
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String msg) { // Tratamento de erro
        super(msg);
    }
}
