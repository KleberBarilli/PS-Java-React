package br.com.banco.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.domain.entities.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

}
