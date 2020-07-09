package com.uca.capas.service;

import com.uca.capas.domain.Departamento;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface DepartamentoService {
    List<Departamento> findAll() throws DataAccessException;
}
