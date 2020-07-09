package com.uca.capas.service;

import com.uca.capas.dto.MunicipioDTO;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface MunicipioService {
    List<MunicipioDTO> municipioDTO(Integer dptoId) throws DataAccessException;
}
