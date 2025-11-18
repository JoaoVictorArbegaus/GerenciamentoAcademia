package com.vithx.academia.gerencia_academia.dto;

public record AlunoRequestDTO(
        String nome,
        String cpf,
        String telefone,
        String email,
        String senha,
        Long unidadeId
) {}
