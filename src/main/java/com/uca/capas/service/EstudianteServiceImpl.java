package com.uca.capas.service;

import java.util.List;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.EstudianteMateria;
import com.uca.capas.repositories.EstudianteMateriaRepository;
import com.uca.capas.repositories.EstudianteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    EstudianteMateriaRepository estudianteRepository;

    @Autowired
    EstudianteRepository estu;

    @Override
    public Estudiante findOne(Integer codigo) throws DataAccessException {
        return estu.getOne(codigo);
    }

    @Override
    public EstudianteMateria findOnes(Integer codigo) throws DataAccessException {
        return estudianteRepository.findEstuMatId(codigo);
    }

    @Override
    public List<EstudianteMateria> getEstuList(Integer codigo) {
        return estudianteRepository.findEstuMatList(codigo);
    }

    @Override
    public void saveEstu(EstudianteMateria estumate) throws DataAccessException {
        try {
            estudianteRepository.save(estumate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estudiante saveAndFlush(Estudiante e) throws DataAccessException {
        return estu.saveAndFlush(e);
    }

}