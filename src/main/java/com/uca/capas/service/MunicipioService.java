package com.uca.capas.service;

import com.uca.capas.domain.Municipio;
import com.uca.capas.dto.MunicipioDTO;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface MunicipioService {
    List<MunicipioDTO> municipioDTO(Integer dptoId) throws DataAccessException;
    List<Municipio> findAll() throws DataAccessException;
    Integer getDeptoByMunicipio(Integer municipioId) throws DataAccessException;
}
