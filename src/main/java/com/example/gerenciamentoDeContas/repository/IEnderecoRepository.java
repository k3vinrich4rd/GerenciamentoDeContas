package com.example.gerenciamentoDeContas.repository;

import com.example.gerenciamentoDeContas.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends JpaRepository<EnderecoModel, Long> {

}
