package com.empresa.inventoryapi.controller;

import com.empresa.inventoryapi.model.Localizacao;
import com.empresa.inventoryapi.service.LocalizacaoService;
import com.empresa.inventoryapi.dto.LocalizacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/localizacoes") 
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @PostMapping
    public ResponseEntity<Localizacao> criarLocalizacao(@RequestBody LocalizacaoRequest request) {
        
        Localizacao novaLocalizacao = new Localizacao();
        novaLocalizacao.setCodigo(request.getCodigo());
        novaLocalizacao.setDescricao(request.getDescricao());

        Localizacao salva = localizacaoService.criar(novaLocalizacao);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public ResponseEntity<List<Localizacao>> buscarTodas() {
        List<Localizacao> localizacoes = localizacaoService.buscarTodas();
        return ResponseEntity.ok(localizacoes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Localizacao> buscarPorId(@PathVariable Long id) {
        Localizacao localizacao = localizacaoService.buscarPorId(id);
        return ResponseEntity.ok(localizacao);
    }
}