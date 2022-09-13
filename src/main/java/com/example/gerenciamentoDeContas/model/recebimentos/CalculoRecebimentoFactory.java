package com.example.gerenciamentoDeContas.model.recebimentos;

public class CalculoRecebimentoFactory {

    public static CalculoDeRecebimentos tipoDeRecebimentos(String tipoDeRecebimentos){
        if (tipoDeRecebimentos.equalsIgnoreCase("EM_ATRASO")){
            return new EmAtraso();
        } else if (tipoDeRecebimentos.equalsIgnoreCase("EM_DIA")) {
            return new EmDia();
        } else if (tipoDeRecebimentos.equalsIgnoreCase("ADIANTADO")) {
            return new Adiantado();
        }else {
            return null;
        }
    }
}
