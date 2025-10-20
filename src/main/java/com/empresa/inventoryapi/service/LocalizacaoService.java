package com.empresa.inventoryapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.inventoryapi.exception.NomeDuplicadoException;
import com.empresa.inventoryapi.exception.RecursoNaoEncontradoException;
import com.empresa.inventoryapi.model.Localizacao;
import com.empresa.inventoryapi.repository.LocalizacaoRepository;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @Transactional
    public Localizacao criar(Localizacao localizacao) {
        if (localizacaoRepository.existsByCodigo(localizacao.getCodigo())) {
            throw new NomeDuplicadoException("O código de localização '" + localizacao.getCodigo() + "' já existe.");
        }
        return localizacaoRepository.save(localizacao);
    }

    @Transactional(readOnly = true)
    public List<Localizacao> buscarTodas() {
        return localizacaoRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Localizacao buscarPorId(Long id) {
        return localizacaoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Localização com ID " + id + " não encontrada."));
    }
}