package com.empresa.inventoryapi.service;

import com.empresa.inventoryapi.model.Estoque;
import com.empresa.inventoryapi.model.Produto;
import com.empresa.inventoryapi.model.Localizacao;
import com.empresa.inventoryapi.repository.EstoqueRepository;
import com.empresa.inventoryapi.exception.RecursoNaoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private LocalizacaoService localizacaoService;

    
    @Transactional
    public Estoque atualizarOuCriar(Long produtoId, Long localizacaoId, Integer novaQuantidade) {
        
        Produto produto = produtoService.buscarPorId(produtoId);
        Localizacao localizacao = localizacaoService.buscarPorId(localizacaoId);
        
        Optional<Estoque> estoqueExistente = estoqueRepository.findByProdutoAndLocalizacao(produto, localizacao);
        
        Estoque estoque;
        
        if (estoqueExistente.isPresent()) {
            estoque = estoqueExistente.get();
            estoque.setQuantidade(novaQuantidade);
            estoque.setUltimaAtualizacao(LocalDateTime.now());
        } else {
            estoque = new Estoque();
            estoque.setProduto(produto);
            estoque.setLocalizacao(localizacao);
            estoque.setQuantidade(novaQuantidade);
        }

        return estoqueRepository.save(estoque);
    }
    

    @Transactional(readOnly = true)
    public Estoque buscarPorId(Long id) {
        return estoqueRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Estoque com ID " + id + " não encontrado."));
    }
    
    @Transactional(readOnly = true)
    public Optional<Estoque> buscarPorProdutoELocalizacao(Long produtoId, Long localizacaoId) {
        Produto produto = produtoService.buscarPorId(produtoId);
        Localizacao localizacao = localizacaoService.buscarPorId(localizacaoId);
        return estoqueRepository.findByProdutoAndLocalizacao(produto, localizacao);
    }
}