package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.dto.EstudianteDTO;

import org.springframework.dao.DataAccessException;

public interface EstudianteService {

    public Estudiante findOne(Integer codigo) throws DataAccessException;
    
    public List<EstudianteDTO> getEstudianteMateriaCodigo(Integer codigo);
}