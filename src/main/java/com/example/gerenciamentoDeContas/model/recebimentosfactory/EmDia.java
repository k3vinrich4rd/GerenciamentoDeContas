package com.example.gerenciamentoDeContas.model.recebimentosfactory;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;

import java.math.BigDecimal;

public class EmDia implements CalculoDeRecebimentos {
    //Lógica feita para o usuario que pagar em dia não ter nenhuma forma de desconto e de taxa de pagamento
    @Override
    public BigDecimal calculoDeRecebimentos(ContasReceberModel contasReceberModel) {
        return (contasReceberModel.getValorRecebimento());
    }
}
