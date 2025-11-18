package com.vithx.academia.gerencia_academia.repository;

import com.vithx.academia.gerencia_academia.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
