package com.example.gerenciamentoDeContas.model.recebimentos;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;

import java.math.BigDecimal;

public class EmDia implements CalculoDeRecebimentos {
    @Override
    public BigDecimal calculoDeRecebimentos(ContasReceberModel contasReceberModel) {
        return (contasReceberModel.getValorRecebimento());
    }
}