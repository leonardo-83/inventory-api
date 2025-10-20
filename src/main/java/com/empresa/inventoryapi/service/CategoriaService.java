package com.empresa.inventoryapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.inventoryapi.exception.NomeDuplicadoException; 
import com.empresa.inventoryapi.exception.RecursoNaoEncontradoException;
import com.empresa.inventoryapi.model.Categoria;
import com.empresa.inventoryapi.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria criar(Categoria categoria) {
        if (categoriaRepository.existsByNome(categoria.getNome())) {
            throw new NomeDuplicadoException("A categoria '" + categoria.getNome() + "' já existe.");
        }
        return categoriaRepository.save(categoria);
    }

    @Transactional(readOnly = true)
    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Categoria com ID " + id + " não encontrada."));
    }
}