package com.desafio.calculadora.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.calculadora.dto.FormDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/calculadora")
public class ControllerCalculadora {

    @PostMapping("calcular")
    public ResponseEntity<?> controllerCalcularEmprestimo(@RequestBody FormDTO dto){

        Integer qtdParcelas = calculoQuantidadeParcelas(dto);

        LocalDate dataInicial = dto.dataInicial();

        for (int i = 1; i < qtdParcelas + 1; i++) {
             //LocalDate dataMetade = dataInicial.withDayOfMonth(15);
             System.out.println(i+" - Data Competência: "+dataInicial+" - Valor de Empréstimo - "+dto.valorEmprestimo());
             dataInicial = dataInicial.plusMonths(1);
        }

        return ResponseEntity.ok().body(qtdParcelas);
    }

    public int calculoQuantidadeParcelas(FormDTO dto){
        return (int) ChronoUnit.MONTHS.between(dto.dataInicial(), dto.dataFinal());
    }

}
