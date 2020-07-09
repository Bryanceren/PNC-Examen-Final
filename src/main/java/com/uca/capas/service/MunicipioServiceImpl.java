package com.uca.capas.service;

import com.uca.capas.dto.MunicipioDTO;
import com.uca.capas.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MunicipioServiceImpl implements MunicipioService{
    @Autowired
    MunicipioRepository municipioRepository;
    @Override
    public List<MunicipioDTO> municipioDTO(Integer dptoId) throws DataAccessException {
        return municipioRepository.muncicipioDTO(dptoId).stream().map(objs->{
            MunicipioDTO municipioDTO = new MunicipioDTO();
            municipioDTO.setId(Integer.parseInt(objs[0].toString()));
            municipioDTO.setNombre(objs[1].toString());
            municipioDTO.setDptoId(dptoId);
            return municipioDTO;
        }).collect(Collectors.toList());
    }
}
