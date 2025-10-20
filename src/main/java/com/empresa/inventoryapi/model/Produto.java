package com.empresa.inventoryapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal; 

@Entity
@Table(name = "PRODUTOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "SKU", nullable = false, unique = true, length = 50)
    private String sku; 

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "PRECO", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco; 

    
    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name = "CATEGORIA_ID", nullable = false) 
    private Categoria categoria;
}