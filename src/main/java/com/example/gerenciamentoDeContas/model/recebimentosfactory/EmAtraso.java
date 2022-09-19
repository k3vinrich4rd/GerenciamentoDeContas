package com.example.gerenciamentoDeContas.model.recebimentosfactory;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;

import java.math.BigDecimal;

public class EmAtraso implements CalculoDeRecebimentos { //Lógica feita para o usuario que pagar em atraso ter
    // 3.5% de taxa de pagamento com base no valor de recebimento que ele informar
    @Override
    public BigDecimal calculoDeRecebimentos(ContasReceberModel contasReceberModel) {
        BigDecimal resultado = contasReceberModel.getValorRecebimento().multiply(new BigDecimal(String.valueOf(0.035)));
        return contasReceberModel.getValorRecebimento().add(resultado);
    }
}
