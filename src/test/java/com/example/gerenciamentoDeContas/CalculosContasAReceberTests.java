package com.example.gerenciamentoDeContas;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;
import com.example.gerenciamentoDeContas.model.recebimentosfactory.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class CalculosContasAReceberTests {

    @Test
    void TestandoCalculoDeContasAReceberEmAtraso() {
        ContasReceberModel contasReceberModel = new ContasReceberModel(); //declara��o da classe e objeto usado para acesso
        contasReceberModel.setValorRecebimento(new BigDecimal("100")); // Usando o objeto declarado
        // para setar o valor de recebimento para simular o calculo da taxa

        EmAtraso emAtraso = new EmAtraso(); //declara��o da classe e objeto usado para acessarmos o m�todo que efetua o c�lculo
        BigDecimal pagamentoEmAtraso = emAtraso.calculoDeRecebimentos(contasReceberModel); //Vari�vel que vai armazenar os valores da conta
        Assertions.assertEquals(new BigDecimal("103.500"), pagamentoEmAtraso); // Resultado final do calculo
    }


    @Test
    void TestandoCalculosDeContasAReceberEmdia() {
        ContasReceberModel contasReceberModel = new ContasReceberModel(); //declara��o da classe e objeto usado para acesso
        contasReceberModel.setValorRecebimento(new BigDecimal("100")); // Usando o objeto declarado
        // para setar o valor de recebimento para simular o calculo da taxa

        EmDia emDia = new EmDia(); //declara��o da classe e objeto usado para acessarmos o m�todo que efetua o c�lculo
        BigDecimal pagamentoEmDia = emDia.calculoDeRecebimentos(contasReceberModel); //Vari�vel que vai armazenar os valores da conta
        Assertions.assertEquals(new BigDecimal("100"), pagamentoEmDia); // Resultado final do calculo
    }


    @Test
    void TestandoCalculoDeContasAReceberAdiantado() {
        ContasReceberModel contasReceberModel = new ContasReceberModel(); //declara��o da classe e objeto usado para acesso
        contasReceberModel.setValorRecebimento(new BigDecimal("100")); // Usando o objeto declarado
        // para setar o valor de recebimento para simular o calculo da taxa

        Adiantado adiantado = new Adiantado(); //declara��o da classe e objeto usado para acessarmos o m�todo que efetua o c�lculo
        BigDecimal pagamentoAdiantado = adiantado.calculoDeRecebimentos(contasReceberModel); //Vari�vel que vai armazenar os valores da conta
        Assertions.assertEquals(new BigDecimal("95.00"), pagamentoAdiantado); // Resultado final do calculo
    }

    @Test
    void TestandoCalculosDeContasAReceberEmpregosClt() {
        ContasReceberModel contasReceberModel = new ContasReceberModel(); //declara��o da classe e objeto usado para acesso
        contasReceberModel.setValorRecebimento(new BigDecimal("100")); // Usando o objeto declarado
        // para setar o valor de recebimento para simular o calculo da taxa

        EmpregosClt empregosClt = new EmpregosClt(); //declara��o da classe e objeto usado para acessarmos o m�todo que efetua o c�lculo
        BigDecimal calculoEmpregoClt = empregosClt.calculoDeRecebimentos(contasReceberModel); //Vari�vel que vai armazenar os valores da conta
        Assertions.assertEquals(new BigDecimal("100"), calculoEmpregoClt); // Resultado final do calculo
    }


    @Test
    void TestandoCalculosDeContasAReceberFreelancer(){
        ContasReceberModel contasReceberModel = new ContasReceberModel(); //declara��o da classe e objeto usado para acesso
        contasReceberModel.setValorRecebimento(new BigDecimal("100")); // Usando o objeto declarado
        // para setar o valor de recebimento para simular o calculo da taxa

        Freelancer freelancer = new Freelancer();  //declara��o da classe e objeto usado para acessarmos o m�todo que efetua o c�lculo
        BigDecimal calculoFreelancer = freelancer.calculoDeRecebimentos(contasReceberModel); //Vari�vel que vai armazenar os valores da conta
        Assertions.assertEquals(new BigDecimal("100"), calculoFreelancer); // Resultado final do calculo
    }

}

