package com.uca.capas.controller;

import java.util.List;

import com.uca.capas.domain.EstudianteMateria;
import com.uca.capas.dto.EstudianteDTO;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.Materia.MateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Secured("ROLE_USER")
public class StudentControllerRest {

    @Autowired
    EstudianteService estu;

    @Autowired
    MateriaService materiaService;

    @PostMapping("/materias-cursadas")
    public ResponseEntity<EstudianteDTO> getCursadas(@RequestParam(name = "param") Integer param) {
        List<EstudianteMateria> estudiantes = estu.getEstuList(param);
        EstudianteDTO dto = new EstudianteDTO(estudiantes);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }
}
