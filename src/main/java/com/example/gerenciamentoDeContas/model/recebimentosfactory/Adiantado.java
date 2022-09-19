package com.example.gerenciamentoDeContas.model.recebimentosfactory;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;

import java.math.BigDecimal;

public class Adiantado implements CalculoDeRecebimentos { //Lógica feita para o usuario que pagar adiantado e ter
    // 5% com base no valor de recebimento que ele informar
    @Override
    public BigDecimal calculoDeRecebimentos(ContasReceberModel contasReceberModel) {
        BigDecimal resultado = contasReceberModel.getValorRecebimento().multiply(new BigDecimal("0.05"));
        return contasReceberModel.getValorRecebimento().subtract(resultado);
    }
}
