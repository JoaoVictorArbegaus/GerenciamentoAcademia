package com.vithx.academia.gerencia_academia.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 50)
    private String categoria;

    @Column(length = 50)
    private String marca;

    @ManyToOne(optional = false)
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;
}
