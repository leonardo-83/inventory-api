package com.empresa.inventoryapi.controller;

import com.empresa.inventoryapi.model.Produto;
import com.empresa.inventoryapi.service.ProdutoService;
import com.empresa.inventoryapi.dto.ProdutoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/produtos") 
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody ProdutoRequest request) {
        
        Produto novoProduto = new Produto();
        novoProduto.setSku(request.getSku());
        novoProduto.setNome(request.getNome());
        novoProduto.setPreco(request.getPreco()); 
        
        Produto salvo = produtoService.criar(novoProduto, request.getCategoriaId());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos() {
        List<Produto> produtos = produtoService.buscarTodos();
        return ResponseEntity.ok(produtos);
    }
}