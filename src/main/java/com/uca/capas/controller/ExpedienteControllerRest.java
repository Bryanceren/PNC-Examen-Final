package com.uca.capas.controller;

import com.uca.capas.domain.Expediente;
import com.uca.capas.dto.ExpedienteDTO;
import com.uca.capas.dto.ExpedienteJson;
import com.uca.capas.service.expediente.ExpedienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Secured("ROLE_USER")
public class
ExpedienteControllerRest {

    @Autowired
    private ExpedienteService expedienteService;

    @PostMapping("/expedientes")
    public ResponseEntity<ExpedienteJson> getExpedientes(@RequestParam(name = "filter") String filter,
                                                         @RequestParam(name = "param") String param) {
        List<ExpedienteDTO> expedientes = expedienteService.findExpedienteByName(param);
        if ("nombre".equals(filter)) {
            ExpedienteJson expedienteJson = new ExpedienteJson(expedientes);
            return new ResponseEntity<>(expedienteJson, HttpStatus.OK);
        }
        return null;
    }

}
