package com.empresa.inventoryapi.repository;

import com.empresa.inventoryapi.model.Estoque;
import com.empresa.inventoryapi.model.Produto;
import com.empresa.inventoryapi.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    Optional<Estoque> findByProdutoAndLocalizacao(Produto produto, Localizacao localizacao);
}