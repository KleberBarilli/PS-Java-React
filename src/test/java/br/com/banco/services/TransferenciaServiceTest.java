package br.com.banco.services;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.banco.domain.entities.Conta;
import br.com.banco.domain.entities.Transferencia;
import br.com.banco.domain.services.TransferenciaService;
import br.com.banco.infra.repositories.TransferenciaRepository;

public class TransferenciaServiceTest {

    private TransferenciaService transferenciaService;

    @Mock
    private TransferenciaRepository transferenciaRepository;

    private Transferencia transferencia1;
    private Transferencia transferencia2;
    private Transferencia transferencia3;

    private Conta conta;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        transferenciaService = new TransferenciaService(transferenciaRepository);

        conta = new Conta();
        conta.setIdConta((long) 1);
        conta.setNomeResponsavel("XPTO");

        transferencia1 = new Transferencia();
        transferencia2 = new Transferencia();
        transferencia3 = new Transferencia();

        transferencia1.setId((long) 1);
        transferencia1.setDataTransferencia(LocalDateTime.now());
        transferencia1.setNomeOperadorTransacao("Kleber");
        transferencia1.setTipo("DEPOSITO");
        transferencia1.setValor(new BigDecimal("500.78"));
        transferencia1.setConta(conta);

        transferencia2.setId((long) 2);
        transferencia2.setDataTransferencia(LocalDateTime.now());
        transferencia2.setNomeOperadorTransacao("Kleber");
        transferencia2.setTipo("SAQUE");
        transferencia2.setValor(new BigDecimal("300"));
        transferencia2.setConta(conta);

        transferencia3.setId((long) 3);
        transferencia3.setDataTransferencia(LocalDateTime.now());
        transferencia3.setNomeOperadorTransacao("Júlia");
        transferencia3.setTipo("SAQUE");
        transferencia3.setValor(new BigDecimal("100"));
        transferencia3.setConta(conta);
    }

    @Test
    public void deveRetornarTodasAsTransferencias() {

        List<Transferencia> transferencias = Arrays.asList(transferencia1, transferencia2, transferencia3);
        when(transferenciaRepository.findAll()).thenReturn(transferencias);
        List<Transferencia> result = transferenciaService.findAll();

        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(transferencia1, result.get(0));
        Assertions.assertEquals(transferencia2, result.get(1));
        Assertions.assertEquals(transferencia3, result.get(2));
    }
}
