package com.uca.capas.dao;

import java.util.List;

import com.uca.capas.domain.Estudiante;

import org.springframework.dao.DataAccessException;

public interface EstudianteDao {

    public Estudiante findOne(Integer codigo) throws DataAccessException;

    public List<Estudiante> getEstudianteNombreMateria(String nombre);
    
}