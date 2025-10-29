package com.desafio.calculadora.dto;

import java.math.BigDecimal;

public record FormDTO(String dataInicial, String dataFinal, String primeiroPagamento, BigDecimal valorEmprestimo, BigDecimal taxaJuros) {
    
}
