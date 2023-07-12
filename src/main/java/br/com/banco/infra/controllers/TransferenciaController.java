package br.com.banco.infra.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.domain.entities.Transferencia;
import br.com.banco.domain.services.TransferenciaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    private final TransferenciaService service;

    @GetMapping
    public ResponseEntity<List<Transferencia>> listar() {

        List<Transferencia> transferencias = service.findAll();

        return ResponseEntity.ok(transferencias);
    }
}
