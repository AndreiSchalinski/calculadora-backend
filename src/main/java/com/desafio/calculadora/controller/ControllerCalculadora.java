package com.desafio.calculadora.controller;

import java.time.LocalDate;
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

        String tabela = "";

        for (int i = 1; i < qtdParcelas + 1; i++) {
             LocalDate dataMetade = dataInicial.withDayOfMonth(15);
             LocalDate ultimoDiaMes = dataInicial.withDayOfMonth(dataInicial.lengthOfMonth());
             tabela += i+" - Data Competência - Início: "+dataInicial+" - | Meio: "+dataMetade+" | Último dia: "+ultimoDiaMes+" | - Valor de Empréstimo - "+dto.valorEmprestimo()+"\n";
             dataInicial = dataInicial.plusMonths(1);
        }

        return ResponseEntity.ok().body(tabela);
    }

    public int calculoQuantidadeParcelas(FormDTO dto){
        return (int) ChronoUnit.MONTHS.between(dto.dataInicial(), dto.dataFinal());
    }

}
