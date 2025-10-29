package com.desafio.calculadora.dto;

import java.math.BigDecimal;

public record JurosDTO(BigDecimal provisao, BigDecimal acumulado, BigDecimal pago ) {
    
}
