package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import com.uca.capas.dao.MateriaDao;
import com.uca.capas.domain.EstudianteMateria;
import com.uca.capas.domain.Materia;
import com.uca.capas.repositories.MateriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    MateriaDao materiaDao;

    @Autowired
    MateriaRepository materiaRepository;

    @Override
    public List<Materia> findAllMaterias() throws DataAccessException {
        return materiaRepository.findAllMaterias();
    }

    @Override
    @Transactional
    public void save(EstudianteMateria estumat) throws DataAccessException {
        materiaDao.save(estumat);

    }
    
}