package com.example.gerenciamentoDeContas.repository;

import com.example.gerenciamentoDeContas.model.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICidadeRepository extends JpaRepository<CidadeModel, Long> {
}
