package com.uca.capas.controller;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.service.CentroEscolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Secured("ROLE_USER")
public class CentroEscolarControllerRest {
    @Autowired
    private CentroEscolarService centroEscolarService;

    @GetMapping("/centros/{id}")
    List<CentroEscolar> findCentrosPorMuni(@PathVariable(name = "id") Integer fk){
        return centroEscolarService.findfindCentroPorMuni(fk);
    }

    @GetMapping("/centro/{id}")
    CentroEscolar findOneCentro(@PathVariable(name = "id") Integer fk){
        return centroEscolarService.findByIdcen(fk);
    }
}
