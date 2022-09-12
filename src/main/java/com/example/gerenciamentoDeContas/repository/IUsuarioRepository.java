package com.example.gerenciamentoDeContas.repository;

import com.example.gerenciamentoDeContas.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
