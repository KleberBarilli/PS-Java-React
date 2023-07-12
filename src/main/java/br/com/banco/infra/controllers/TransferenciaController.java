package br.com.banco.infra.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<Transferencia>> listar(
            @RequestParam(value = "dataInicial", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial,
            @RequestParam(value = "dataFinal", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal,
            @RequestParam(value = "nomeOperador", required = false) String nomeOperador) {

        if (dataInicial != null && dataFinal != null && dataFinal.isBefore(dataInicial)) {
            throw new IllegalArgumentException("A data final não pode ser menor que a data inicial");

        }

        List<Transferencia> transferencias = service.obterTransferencias(dataInicial, dataFinal, nomeOperador);

        return ResponseEntity.ok(transferencias);
    }
}
