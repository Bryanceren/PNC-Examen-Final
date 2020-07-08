package com.uca.capas.service.expediente;

import com.uca.capas.domain.Expediente;
import com.uca.capas.dto.ExpedienteDTO;
import com.uca.capas.repositories.ExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpedienteServiceImpl implements ExpedienteService{

    @Autowired
    ExpedienteRepository expedienteRepository;

    @Override
    public List<Expediente> findAllByName(String name) {
        return expedienteRepository.findAllByNombre(name);
    }

    @Override
    public List<ExpedienteDTO> findExpedienteByName(String name) {
        return expedienteRepository.expedienteDTO(name).stream().map(objs->{
           ExpedienteDTO expedienteDTO = new ExpedienteDTO();
           expedienteDTO.setNombre(objs[0].toString());
           expedienteDTO.setApellido(objs[1].toString());
           expedienteDTO.setMateriasAprobadas(objs[2].toString());
           expedienteDTO.setMateriasReprobadas(objs[3].toString());
           expedienteDTO.setPromedio(objs[4].toString());
           return expedienteDTO;
        }).collect(Collectors.toList());
    }
}
