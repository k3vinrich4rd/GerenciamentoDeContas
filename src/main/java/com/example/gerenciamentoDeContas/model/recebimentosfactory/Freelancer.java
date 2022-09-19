package com.example.gerenciamentoDeContas.model.recebimentosfactory;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;

import java.math.BigDecimal;

public class Freelancer implements CalculoDeRecebimentos { //Lógica feita para o usuario que informar como
    // tipo de recebimento "freelancer" e não ser cobrado nenhuma taxa e nenhum desconto
    @Override
    public BigDecimal calculoDeRecebimentos(ContasReceberModel contasReceberModel) {
        return contasReceberModel.getValorRecebimento();
    }
}
