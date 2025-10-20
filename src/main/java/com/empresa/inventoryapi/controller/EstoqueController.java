package com.empresa.inventoryapi.controller;

import com.empresa.inventoryapi.model.Estoque;
import com.empresa.inventoryapi.service.EstoqueService;
import com.empresa.inventoryapi.dto.EstoqueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PutMapping
    public ResponseEntity<Estoque> atualizarEstoque(@RequestBody EstoqueRequest request) {
        
        Estoque estoqueSalvo = estoqueService.atualizarOuCriar(
            request.getProdutoId(),
            request.getLocalizacaoId(),
            request.getQuantidade()
        );
        
        return ResponseEntity.ok(estoqueSalvo); 
    }

    @GetMapping
    public ResponseEntity<Estoque> buscarEstoquePorLocalizacao(
            @RequestParam Long produtoId, 
            @RequestParam Long localizacaoId) {
        
        Optional<Estoque> estoque = estoqueService.buscarPorProdutoELocalizacao(produtoId, localizacaoId);
        
        return estoque.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build()); 
    }
}