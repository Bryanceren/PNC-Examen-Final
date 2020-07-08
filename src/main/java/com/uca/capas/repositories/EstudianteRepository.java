package com.uca.capas.repositories;

import com.uca.capas.domain.Estudiante;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    @Query(value = "SELECT * from public.estudiante where id = :estudiante", nativeQuery = true)
    public Estudiante findEstudianteById(@Param("estudiante") Integer estudiante);

}