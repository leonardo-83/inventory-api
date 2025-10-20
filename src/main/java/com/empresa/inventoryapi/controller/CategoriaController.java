package com.empresa.inventoryapi.controller;

import com.empresa.inventoryapi.model.Categoria;
import com.empresa.inventoryapi.service.CategoriaService;
import com.empresa.inventoryapi.dto.CategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias") 
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody CategoriaRequest request) {
        
        Categoria novaCategoria = new Categoria();
        novaCategoria.setNome(request.getNome());
        novaCategoria.setDescricao(request.getDescricao());

        Categoria salva = categoriaService.criar(novaCategoria);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodas() {
        List<Categoria> categorias = categoriaService.buscarTodos();
        return ResponseEntity.ok(categorias);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        Categoria categoria = categoriaService.buscarPorId(id);
        return ResponseEntity.ok(categoria);
    }
}