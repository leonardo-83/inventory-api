package com.empresa.inventoryapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "LOCALIZACOES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "localizacao_seq")
    @SequenceGenerator(name = "localizacao_seq", sequenceName = "LOCALIZACAO_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", nullable = false, unique = true, length = 50)
    private String codigo; 

    @Column(name = "DESCRICAO", length = 255)
    private String descricao;
}