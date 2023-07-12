package br.com.banco.infra.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.banco.domain.entities.Transferencia;

import java.time.LocalDate;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query("SELECT t FROM Transferencia t WHERE t.dataTransferencia >= :dataInicial AND t.dataTransferencia < :dataFinal")
    List<Transferencia> buscarPorIntervaloDeData(LocalDate dataInicial, LocalDate dataFinal);
}
