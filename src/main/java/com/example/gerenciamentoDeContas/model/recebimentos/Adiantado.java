package com.example.gerenciamentoDeContas.model.recebimentos;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;

import java.math.BigDecimal;

public class Adiantado implements CalculoDeRecebimentos {
    @Override
    public BigDecimal calculoDeRecebimentos(ContasReceberModel contasReceberModel) {
        BigDecimal resultado = contasReceberModel.getValorRecebimento().multiply(new BigDecimal("0.05"));
        return contasReceberModel.getValorRecebimento().subtract(resultado);
    }
}
