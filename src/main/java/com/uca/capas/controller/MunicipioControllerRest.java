package com.uca.capas.controller;

import com.uca.capas.dto.MunicipioDTO;
import com.uca.capas.dto.MunicipioJson;
import com.uca.capas.service.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Secured("ROLE_USER")
public class MunicipioControllerRest {
    @Autowired
    private MunicipioService municipioService;

    @GetMapping("/municipios/{dptoId}")
    ResponseEntity<MunicipioJson> getMunicipios(@PathVariable Integer dptoId){
        List<MunicipioDTO> municipioDTOS = municipioService.municipioDTO(dptoId);
        MunicipioJson municipioJson = new MunicipioJson(municipioDTOS);
        return new ResponseEntity<>(municipioJson, HttpStatus.OK);
    }
}
