package com.desafio.calculadora.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.calculadora.dto.FormDTO;
import com.desafio.calculadora.service.ServiceCalculosDias;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/calculadora")
public class ControllerCalculadora {

    @PostMapping("calcular")
    public ResponseEntity<?> controllerCalcularEmprestimo(@RequestBody FormDTO dto){
        return ResponseEntity.ok().body(calculoQuantidadeParcelas(dto));
    }

    public Long calculoQuantidadeParcelas(FormDTO dto){
        return ChronoUnit.MONTHS.between(dto.dataInicial(), dto.dataFinal());
    }


}
