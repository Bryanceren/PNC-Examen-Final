package com.uca.capas.service.expediente;

import com.uca.capas.domain.Expediente;
import com.uca.capas.repositories.ExpedienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpedienteServiceImpl implements ExpedienteService{

    @Autowired
    ExpedienteRepository expedienteRepository;

    @Override
    public List<Expediente> findAllByName(String name) {
        return expedienteRepository.findAllByNombreStartingWith(name);
    }

    @Override
    public List<Expediente> findAllByApellido(String apellido) {
        return expedienteRepository.findAllByApellidoStartingWith(apellido);
    }


}
