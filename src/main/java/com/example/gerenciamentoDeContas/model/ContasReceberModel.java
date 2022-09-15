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
public class ContasReceberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "recebimento_contas_receber", length = 50, nullable = false)
    private String recebimento;

    @Column(name = "valor_recebimento_contas_receber", length = 200, nullable = false)
    @Min(value = 0, message = "Erro, o valor informado tem que ser superior a 0")
    private BigDecimal valorRecebimento;

    @Enumerated(EnumType.STRING)

    private TipoRecebimento tipoRecebimento;

    @Column(name = "data_de_vencimento_contas_receber", length = 25, nullable = false)
    private LocalDate dataDeVencimento;

    @Enumerated(EnumType.STRING)
    private RecebimentoAlugueis recebimentoAlugueis;

    @Column(name = "data_de_recebimento_contas_receber")
    public LocalDateTime dataDeRecebimento;

    @Column(name = "status_contas_receber", length = 16, nullable = false)
    private String status;


    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "codigo")
    private UsuarioModel usuarioModel;


}
