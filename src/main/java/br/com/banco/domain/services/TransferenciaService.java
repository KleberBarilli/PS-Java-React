package br.com.banco.domain.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.banco.domain.entities.Transferencia;
import br.com.banco.domain.responses.TransferenciaResponse;
import br.com.banco.infra.repositories.TransferenciaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferenciaService {

    private final TransferenciaRepository repository;

    public TransferenciaResponse obterTransferencias(LocalDate dataInicial, LocalDate dataFinal, String nomeOperador,
            int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<Transferencia> transferencias;

        if (dataInicial != null && dataFinal != null && nomeOperador == null) {
            transferencias = repository.buscarPorIntervaloDeData(pageable, dataInicial, dataFinal.plusDays(1));

        } else if (dataInicial != null && dataFinal != null && nomeOperador != null) {
            transferencias = repository.buscarPorIntervaloDeDataENomeOperador(pageable, dataInicial,
                    dataFinal.plusDays(1),
                    nomeOperador);

        } else if (dataInicial == null && dataFinal == null && nomeOperador != null) {
            transferencias = repository.findAllByNomeOperadorTransacaoIgnoreCase(pageable, nomeOperador);

        } else {
            transferencias = repository.findAll(pageable);

        }
        TransferenciaResponse transferenciaResponse = new TransferenciaResponse();
        transferenciaResponse.setTransferencias(transferencias.getContent());
        transferenciaResponse.setPageNumber(transferencias.getNumber());
        transferenciaResponse.setPageSize(transferencias.getSize());
        transferenciaResponse.setTotalElements(transferencias.getNumberOfElements());
        transferenciaResponse.setTotalPages(transferencias.getTotalPages());
        transferenciaResponse.setLast(transferencias.isLast());

        BigDecimal saldoTotal = BigDecimal.ZERO;

        for (Transferencia transferencia : transferencias.getContent()) {
            saldoTotal = saldoTotal.add(transferencia.getValor());
        }

        double saldoTotalDouble = saldoTotal.doubleValue();
        transferenciaResponse.setSaldoTotal(saldoTotalDouble);

        BigDecimal saldoNoPeriodo = BigDecimal.ZERO;
        for (Transferencia transferencia : transferencias.getContent()) {
            saldoNoPeriodo = saldoNoPeriodo.add(transferencia.getValor());
        }
        double saldoNoPeriodoDouble = saldoNoPeriodo.doubleValue();

        transferenciaResponse.setSaldoNoPeriodo(saldoNoPeriodoDouble);

        return transferenciaResponse;
    }

}
