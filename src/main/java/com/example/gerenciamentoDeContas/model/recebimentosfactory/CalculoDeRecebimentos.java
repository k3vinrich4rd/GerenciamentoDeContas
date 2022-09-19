package com.example.gerenciamentoDeContas.model.recebimentosfactory;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;

import java.math.BigDecimal;

public interface CalculoDeRecebimentos { // Interface que com a lógica que será implementada pelas classes
    public BigDecimal calculoDeRecebimentos(ContasReceberModel contasReceberModel);
}
