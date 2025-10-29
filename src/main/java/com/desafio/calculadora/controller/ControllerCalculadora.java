package com.desafio.calculadora.controller;

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
    public ResponseEntity<FormDTO> controllerCalcularEmprestimo(@RequestBody FormDTO dto){
        return ResponseEntity.ok().body(dto);
    }
    
}
