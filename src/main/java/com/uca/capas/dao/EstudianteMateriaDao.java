package com.uca.capas.dao;

import com.uca.capas.domain.EstudianteMateria;

import org.springframework.dao.DataAccessException;

public interface EstudianteMateriaDao
{
    public void save(EstudianteMateria estumat) throws DataAccessException;
}