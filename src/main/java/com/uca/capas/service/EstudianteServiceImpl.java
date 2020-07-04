package com.uca.capas.service;

import java.util.List;
import java.util.stream.Collectors;

import com.uca.capas.dao.EstudianteDao;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.dto.EstudianteDTO;
import com.uca.capas.repositories.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    EstudianteDao estudianteDao;

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public Estudiante findOne(Integer codigo) throws DataAccessException {
        return estudianteRepository.getOne(codigo);
    }

    @Override
    public List<EstudianteDTO> getEstudianteMateriaCodigo(Integer codigo) {
        List<EstudianteDTO> estudiantes = estudianteDao.getEstudianteMateriaCodigo(codigo).stream().map(c -> {
            EstudianteDTO dto = new EstudianteDTO();
			dto.setNombres(c.getEstudiante().getNombre());
            dto.setApellidos(c.getEstudiante().getApellido());
            dto.setNota(c.getNota());
            dto.setAnio(c.getAnio());
            dto.setCiclo(c.getCiclo());
            dto.setMateriaNom(c.getMateria().getNombre());
			return dto;
		}).collect(Collectors.toList());

		return estudiantes;
    }
    
}