package com.example.gerenciamentoDeContas.model.recebimentosfactory;

import com.example.gerenciamentoDeContas.enumeric.RecebimentoAlugueis;
import com.example.gerenciamentoDeContas.enumeric.TipoRecebimento;

//Classe factory que faz uma estrutura condicional com base no que o usuário informar
public class CalculoRecebimentoFactory {


    public static CalculoDeRecebimentos tipoDeRecebimentos(RecebimentoAlugueis recebimentoAlugueis, TipoRecebimento tipoRecebimento) {
        if (recebimentoAlugueis == RecebimentoAlugueis.EM_ATRASO) {
            return new EmAtraso();
        } else if (recebimentoAlugueis == RecebimentoAlugueis.EM_DIA) {
            return new EmDia();
        } else if (recebimentoAlugueis == RecebimentoAlugueis.ADIANTADO) {
            return new Adiantado();
        } else if (tipoRecebimento == TipoRecebimento.EMPREGO_CLT) {
            return new EmpregosClt();
        } else if (tipoRecebimento == TipoRecebimento.FREELANCER) {
            return new Freelancer();
        } else {
            return null;
        }
    }
}
