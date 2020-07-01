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

    //test buscar por nombre de materia con criteria
    @Override
    public List<EstudianteDTO> getEstudianteMateria(String nombre) {
        List<EstudianteDTO> estudiantes = estudianteDao.getEstudianteNombreMateria(nombre).stream().map(c -> {
			EstudianteDTO dto = new EstudianteDTO();
			dto.setCodigo(c.getIdEstudiante().toString());
			dto.setNombres(c.getNombre());
            dto.setApellidos(c.getApellido());
			return dto;
		}).collect(Collectors.toList());

		return estudiantes;
    }
    
}