package com.empresa.inventoryapi.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProdutoRequest {
    
    private String sku;
    private String nome;
    private BigDecimal preco;

    private Long categoriaId; 
}