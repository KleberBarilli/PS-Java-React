package br.com.banco.domain.responses;

import java.util.List;

import br.com.banco.domain.entities.Transferencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaResponse {

    private List<Transferencia> transferencias;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
    private double saldoTotal;
    private double saldoNoPeriodo;
}
