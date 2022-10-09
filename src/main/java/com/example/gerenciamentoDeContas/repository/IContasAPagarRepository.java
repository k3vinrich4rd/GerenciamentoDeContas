package com.example.gerenciamentoDeContas.repository;

import com.example.gerenciamentoDeContas.enumeric.Status;
import com.example.gerenciamentoDeContas.enumeric.Tipo;
import com.example.gerenciamentoDeContas.model.ContasAPagarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IContasAPagarRepository extends JpaRepository<ContasAPagarModel, UUID> {

    public List<ContasAPagarModel> findByStatus(Status status); // Query methods (Métodos de consulta)

    public List<ContasAPagarModel> findByTipo(Tipo tipo);// Query methods (Métodos de consulta)



}
