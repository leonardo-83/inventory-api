package com.empresa.inventoryapi.service;

import com.empresa.inventoryapi.model.Categoria;
import com.empresa.inventoryapi.model.Produto;
import com.empresa.inventoryapi.repository.ProdutoRepository;
import com.empresa.inventoryapi.exception.RecursoNaoEncontradoException;
import com.empresa.inventoryapi.exception.NomeDuplicadoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaService categoriaService;

	@Transactional
	public Produto criar(Produto produto, Long categoriaId) {

		if (produtoRepository.existsBySku(produto.getSku())) {
			throw new NomeDuplicadoException("O SKU '" + produto.getSku() + "' já está cadastrado.");
		}

		Categoria categoria = categoriaService.buscarPorId(categoriaId);

		produto.setCategoria(categoria);

		return produtoRepository.save(produto);
	}

	@Transactional(readOnly = true)
	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Produto buscarPorId(Long id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado."));
	}
}