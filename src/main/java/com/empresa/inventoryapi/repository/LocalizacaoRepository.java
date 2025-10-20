package com.empresa.inventoryapi.repository;

import com.empresa.inventoryapi.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {

    boolean existsByCodigo(String codigo);
}