package com.empresa.inventoryapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data // <-- ESTA ANOTAÇÃO É ESSENCIAL
public class LocalizacaoRequest {

    // O nome da variável deve ser exatamente 'codigo'
    @NotBlank(message = "O código da localização é obrigatório.")
    @Size(max = 50, message = "O código não pode exceder 50 caracteres.")
    private String codigo; 

    @Size(max = 255, message = "A descrição não pode exceder 255 caracteres.")
    private String descricao;
}