package com.example.gerenciamentoDeContas.model.recebimentos;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;

import java.math.BigDecimal;

public class EmAtraso implements CalculoDeRecebimentos {
    @Override
    public BigDecimal calculoDeRecebimentos(ContasReceberModel contasReceberModel) {
        BigDecimal resultado = contasReceberModel.getValorRecebimento().multiply(new BigDecimal("0.035"));
        return contasReceberModel.getValorRecebimento().add(resultado);
    }
}
