package br.com.banco.domain.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.banco.domain.entities.Transferencia;
import br.com.banco.infra.repositories.TransferenciaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferenciaService {

    private final TransferenciaRepository repository;

    public List<Transferencia> obterTransferencias(LocalDate dataInicial, LocalDate dataFinal, String nomeOperador) {

        if (dataInicial != null && dataFinal != null && nomeOperador == null) {
            return repository.buscarPorIntervaloDeData(dataInicial, dataFinal.plusDays(1));

        } else if (dataInicial != null && dataFinal != null && nomeOperador != null) {
            return repository.buscarPorIntervaloDeDataENomeOperador(dataInicial, dataFinal.plusDays(1), nomeOperador);

        } else if (dataInicial == null && dataFinal == null && nomeOperador != null) {
            return repository.findAllByNomeOperadorTransacaoIgnoreCase(nomeOperador);

        } else {
            return repository.findAll();
        }
    }

}
