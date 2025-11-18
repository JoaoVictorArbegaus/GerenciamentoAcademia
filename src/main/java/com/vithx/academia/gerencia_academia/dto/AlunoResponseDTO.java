package com.vithx.academia.gerencia_academia.dto;

import java.time.LocalDateTime;

public record AlunoResponseDTO(
        Long id,
        String nome,
        String cpf,
        String telefone,
        String email,
        LocalDateTime dataCadastro,
        Long unidadeId,
        String unidadeNome
) {}

