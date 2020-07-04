package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.EstudianteMateria;
import com.uca.capas.domain.Materia;

import org.springframework.dao.DataAccessException;

public interface MateriaService {

    public void save(EstudianteMateria estumat) throws DataAccessException;

    public List<Materia> findAllMaterias();
    
}