package com.uca.capas.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uca.capas.domain.EstudianteMateria;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MateriaDaoImpl implements MateriaDao {

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public void save(EstudianteMateria estumat) throws DataAccessException {
        try {
            if (estumat.getId() == null) {
                entityManager.persist(estumat);;
            }
            else {
                entityManager.merge(estumat);
                entityManager.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}