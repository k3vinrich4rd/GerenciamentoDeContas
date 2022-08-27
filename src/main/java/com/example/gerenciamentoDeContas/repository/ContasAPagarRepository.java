package com.example.gerenciamentoDeContas.repository;

import com.example.gerenciamentoDeContas.enumeric.Status;
import com.example.gerenciamentoDeContas.enumeric.Tipo;
import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagarModel, Long> {

    public List<ContasAPagarModel> findByStatus(Status status);

    public List<ContasAPagarModel> findByTipo(Tipo tipo);


}
