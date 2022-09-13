package com.example.gerenciamentoDeContas.model.recebimentos;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;

import java.math.BigDecimal;

public interface CalculoDeRecebimentos {
    public BigDecimal calculoDeRecebimentos(ContasReceberModel contasReceberModel);
}
