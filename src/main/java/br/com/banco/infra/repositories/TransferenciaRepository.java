package br.com.banco.infra.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.banco.domain.entities.Transferencia;

import java.time.LocalDate;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query("SELECT t FROM Transferencia t WHERE t.dataTransferencia >= :dataInicial AND t.dataTransferencia < :dataFinal")
    Page<Transferencia> buscarPorIntervaloDeData(Pageable pageable, LocalDate dataInicial, LocalDate dataFinal);

    @Query("SELECT t FROM Transferencia t WHERE t.dataTransferencia >= :dataInicial AND t.dataTransferencia < :dataFinal AND LOWER(t.nomeOperadorTransacao) = LOWER(:nomeOperador)")
    Page<Transferencia> buscarPorIntervaloDeDataENomeOperador(Pageable pageable, LocalDate dataInicial,
            LocalDate dataFinal,
            String nomeOperador);

    Page<Transferencia> findAllByNomeOperadorTransacaoIgnoreCase(Pageable pageable, String nome);

}
