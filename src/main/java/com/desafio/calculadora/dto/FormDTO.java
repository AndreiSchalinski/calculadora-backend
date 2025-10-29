package com.desafio.calculadora.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FormDTO(LocalDate dataInicial, LocalDate dataFinal, LocalDate primeiroPagamento, BigDecimal valorEmprestimo, BigDecimal taxaJuros) {
    
}
