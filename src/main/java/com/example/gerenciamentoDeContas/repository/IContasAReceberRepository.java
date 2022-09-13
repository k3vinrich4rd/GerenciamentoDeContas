package com.example.gerenciamentoDeContas.repository;

import com.example.gerenciamentoDeContas.model.ContasReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContasAReceberRepository extends JpaRepository<ContasReceberModel, Long> {
}
