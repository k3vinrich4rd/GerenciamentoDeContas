package com.example.gerenciamentoDeContas.model;

import com.example.gerenciamentoDeContas.enumeric.RecebimentoAlugueis;
import com.example.gerenciamentoDeContas.enumeric.TipoRecebimento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Validated
@Table(name = "contas_receber")
//Métodos assessores, modificadores, construtor, construtor vazio, entidade e tabela
public class ContasReceberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo; //Primary key

    @Column(name = "recebimento_contas_receber", length = 50, nullable = false)
    private String recebimento; //Coluna

    @Column(name = "valor_recebimento_contas_receber", length = 200, nullable = false)
    @Min(value = 0, message = "Erro, o valor informado tem que ser superior a 0")
    private BigDecimal valorRecebimento; //Coluna

    @Enumerated(EnumType.STRING) //Tipo enum
    private TipoRecebimento tipoRecebimento; //Coluna

    @Column(name = "data_de_vencimento_contas_receber", length = 25, nullable = false)
    private LocalDate dataDeVencimento; //Coluna

    @Enumerated(EnumType.STRING) //Tipo enum
    private RecebimentoAlugueis recebimentoAlugueis; //Coluna

    @Column(name = "data_de_recebimento_contas_receber") // Coluna
    public LocalDateTime dataDeRecebimento; //Tipo LocalDate

    @Column(name = "status_contas_receber", length = 16, nullable = false) //Coluna
    private String status;


    @ManyToOne //Relacionamento de muitos para um
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo") //Junção de colunas
    private UsuarioModel usuarioModel; //foreign key


}
