package com.uca.capas.dao;

import java.util.List;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.EstudianteMateria;

public interface EstudianteDao {

    public List<Estudiante> getEstudianteNombreMateria(String nombre);

    public List<EstudianteMateria> getEstudianteMateriaCodigo(Integer codigo);
    
}