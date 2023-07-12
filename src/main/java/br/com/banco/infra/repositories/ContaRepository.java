package br.com.banco.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.domain.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
