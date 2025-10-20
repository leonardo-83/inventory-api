package com.empresa.inventoryapi.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

@Data
public class EstoqueRequest {
    
    @NotNull(message = "O ID do produto é obrigatório.")
    private Long produtoId;
    
    @NotNull(message = "O ID da localização é obrigatório.")
    private Long localizacaoId;
    
    @NotNull(message = "A quantidade é obrigatória.")
    @Min(value = 0, message = "A quantidade inicial não pode ser negativa.")
    private Integer quantidade;
}