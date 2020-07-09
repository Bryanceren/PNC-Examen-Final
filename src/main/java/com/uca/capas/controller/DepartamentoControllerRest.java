package com.uca.capas.controller;

import com.uca.capas.domain.Departamento;
import com.uca.capas.dto.DepartamentoJson;
import com.uca.capas.service.Departamento.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Secured("ROLE_USER")
public class DepartamentoControllerRest {
    @Autowired
    DepartamentoService departamentoService;

    @GetMapping("/departamentos")
    ResponseEntity<DepartamentoJson> getDepartamentos(){
        List<Departamento> departamentos = departamentoService.findAll();
        DepartamentoJson departamentoJson = new DepartamentoJson(departamentos);
        return new ResponseEntity<>(departamentoJson, HttpStatus.OK);
    }
}
