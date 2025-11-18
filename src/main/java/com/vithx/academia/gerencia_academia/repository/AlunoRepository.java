package com.vithx.academia.gerencia_academia.repository;

import com.vithx.academia.gerencia_academia.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
