package com.example.gerenciamentoDeContas.repository;

import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagarModel, Long> {
}
