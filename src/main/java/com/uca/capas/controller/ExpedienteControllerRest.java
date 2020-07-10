package com.uca.capas.controller;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.Expediente;
import com.uca.capas.dto.ExpedienteJson;
import com.uca.capas.service.EstudianteService;
import com.uca.capas.service.expediente.ExpedienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@Secured("ROLE_USER")
public class
ExpedienteControllerRest {

    @Autowired
    private ExpedienteService expedienteService;

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/expedientes")
    public ResponseEntity<ExpedienteJson> getExpedientes(@RequestParam(name = "filter") String filter,
                                                         @RequestParam(name = "param") String param) {
        List<Expediente> expedientes;

        if ("nombre".equals(filter)) {
            expedientes = expedienteService.findAllByName(param);
            ExpedienteJson expedienteJson = new ExpedienteJson(expedientes);
            return new ResponseEntity<>(expedienteJson, HttpStatus.OK);
        }else if("apellido".equals(filter)){
            expedientes = expedienteService.findAllByApellido(param);
            ExpedienteJson expedienteJson = new ExpedienteJson(expedientes);
            return new ResponseEntity<>(expedienteJson, HttpStatus.OK);

        }
        return null;
    }
    @PostMapping("/expediente")
    public Estudiante saveExpediente(@RequestBody @Valid Estudiante estudiante){
//        try{
            return estudianteService.saveAndFlush(estudiante);
//        }catch (Exception e){
//            e.printStackTrace();

//        }
    }
    @GetMapping("/expediente/{id}")
    public Estudiante getExpediente(@PathVariable(name = "id") Integer id){
        return estudianteService.findOneQuery(id);
    }
    @PostMapping("actualizar/{id}")
    public ResponseEntity<Object> actualizarExpediente(
            @PathVariable(name = "id") Integer id,
            @RequestBody @Valid Estudiante estudiante
    ){
        Map<String, Object> body = new LinkedHashMap<>();
        estudianteService.updateEstudiente(id,estudiante);
        body.put("result","ok!");
        return new ResponseEntity<>(body,HttpStatus.OK);
    }


}
