package com.desafio.calculadora.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.calculadora.dto.FormDTO;
import com.desafio.calculadora.dto.TabelaDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/calculadora")
public class ControllerCalculadora {

    @PostMapping("calcular")
    public ResponseEntity<List<TabelaDTO>> controllerCalcularEmprestimo(@RequestBody FormDTO dto){

        List<TabelaDTO> listLinhasTabela = new ArrayList<>();

        Integer qtdParcelas = calculoQuantidadeParcelas(dto);

        LocalDate dataInicial = dto.dataInicial();

        String tabela = "";

        for (int i = 1; i < qtdParcelas + 1; i++) {
             LocalDate dataMetade = dataInicial.withDayOfMonth(15);
             LocalDate ultimoDiaMes = dataInicial.withDayOfMonth(dataInicial.lengthOfMonth());
             
             tabela += i+" - Data Competência - Início: "+dataInicial+" - | Meio: "+dataMetade+" | Último dia: "+ultimoDiaMes+" | - Valor de Empréstimo - "+dto.valorEmprestimo()+"\n";
             listLinhasTabela.add(new TabelaDTO(dataInicial));
             
             dataInicial = dataInicial.plusMonths(1);
        }

        return ResponseEntity.ok().body(listLinhasTabela);
    }

    public int calculoQuantidadeParcelas(FormDTO dto){
        return (int) ChronoUnit.MONTHS.between(dto.dataInicial(), dto.dataFinal());
    }

}
