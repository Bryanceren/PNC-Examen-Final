package com.uca.capas.repositories;

import com.uca.capas.domain.Expediente;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpedienteRepository extends JpaRepository<Expediente,String> {

    List<Expediente> findAllByNombre(String nombre) throws DataAccessException;
}
