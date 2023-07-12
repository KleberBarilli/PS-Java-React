package br.com.banco.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.banco.domain.entities.Transferencia;
import br.com.banco.infra.repositories.TransferenciaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferenciaService {

    private final TransferenciaRepository repository;

    public List<Transferencia> findAll() {
        return repository.findAll();
    }
}
