package com.uca.capas.repositories;

import com.uca.capas.domain.Expediente;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpedienteRepository extends JpaRepository<Expediente,String> {


    @Query(nativeQuery = true, value = "select * from public.estudiante_materia_resultado_final where nombre=:nombre ")
    List<Object[]> expedienteDTO(String nombre);
    List<Expediente> findAllByNombre(String nombre) throws DataAccessException;
    List<Expediente> findAllByApellido(String apellido) throws DataAccessException;
}
