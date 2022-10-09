package com.example.gerenciamentoDeContas.repository;

import com.example.gerenciamentoDeContas.enumeric.TipoRecebimento;
import com.example.gerenciamentoDeContas.model.ContasReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface IContasAReceberRepository extends JpaRepository<ContasReceberModel, UUID> {
    public List<ContasReceberModel> findByStatus(String status);

    public List<ContasReceberModel> findByTipoRecebimento(TipoRecebimento tipoRecebimento);
    public List<ContasReceberModel> findByDataDeVencimento(LocalDate dataDeVencimento);
}
