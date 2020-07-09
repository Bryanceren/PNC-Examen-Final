package com.uca.capas.service.Departamento;

import com.uca.capas.domain.Departamento;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface DepartamentoService
{
    public List<Departamento> findAll() throws DataAccessException;
}
