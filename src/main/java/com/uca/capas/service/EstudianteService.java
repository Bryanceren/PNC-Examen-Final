package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.EstudianteMateria;
import org.springframework.dao.DataAccessException;

public interface EstudianteService {

    public Estudiante findOne(Integer codigo) throws DataAccessException;

    public List<EstudianteMateria> getEstuList(Integer codigo);

    public EstudianteMateria findOnes(Integer codigo) throws DataAccessException;

    public void saveEstu(EstudianteMateria estumate) throws DataAccessException;

}