package br.com.banco.infra.controllers;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.constants.AppConstants;
import br.com.banco.domain.responses.TransferenciaResponse;
import br.com.banco.domain.services.TransferenciaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    private final TransferenciaService service;

    @GetMapping
    public ResponseEntity<TransferenciaResponse> listar(
            @RequestParam(value = "dataInicial", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicial,
            @RequestParam(value = "dataFinal", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFinal,
            @RequestParam(value = "nomeOperador", required = false) String nomeOperador,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "pageNumber", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNumber) {

        if (dataInicial != null && dataFinal != null && dataFinal.isBefore(dataInicial)) {
            throw new IllegalArgumentException("A data final não pode ser menor que a data inicial");

        }

        TransferenciaResponse transferencias = service.obterTransferencias(dataInicial, dataFinal, nomeOperador,
                pageNumber, pageSize);

        return ResponseEntity.ok(transferencias);
    }
}
