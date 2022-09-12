package com.example.gerenciamentoDeContas.repository;

import com.example.gerenciamentoDeContas.model.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<EstadoModel, Long> {
}
