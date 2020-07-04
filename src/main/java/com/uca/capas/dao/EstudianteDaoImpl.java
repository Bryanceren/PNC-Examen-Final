package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.domain.EstudianteMateria;
import org.springframework.stereotype.Repository;

@Repository
public class EstudianteDaoImpl implements EstudianteDao {

    @PersistenceContext(unitName = "capas")
    EntityManager entityManager;

    // test buscar por nombre de materia con criteria
    @Override
    public List<Estudiante> getEstudianteNombreMateria(String nombre) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Estudiante> query = cb.createQuery(Estudiante.class);

        Root<Estudiante> estudiantes = query.from(Estudiante.class);

        Predicate predicate = cb.equal(estudiantes.join("estumate").join("materia").get("nombre"), nombre);

        query.distinct(true).select(estudiantes).where(predicate);

        List<Estudiante> resultado = entityManager.createQuery(query).getResultList();

        return resultado;
    }

    @Override
    public List<EstudianteMateria> getEstudianteMateriaCodigo(Integer codigo) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<EstudianteMateria> query = cb.createQuery(EstudianteMateria.class);

        Root<EstudianteMateria> estudiantes = query.from(EstudianteMateria.class);

        Predicate predicate = cb.equal(estudiantes.join("estudiante").get("idEstudiante"), codigo);

        query.distinct(true).select(estudiantes).where(predicate);

        List<EstudianteMateria> resultado = entityManager.createQuery(query).getResultList();

        return resultado;
    }
    
}