package com.uca.capas.repositories;

import java.util.List;

import com.uca.capas.domain.EstudianteMateria;
import com.uca.capas.domain.Materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {

    @Query(value = "select * from public.materia", nativeQuery = true)
    public List<Materia> findAllMaterias();
    
}