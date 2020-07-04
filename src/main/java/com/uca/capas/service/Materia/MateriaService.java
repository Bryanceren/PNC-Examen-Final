package com.uca.capas.service.Materia;

import com.uca.capas.domain.EstudianteMateria;
import com.uca.capas.domain.Materia;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface MateriaService
{
	public List<Materia> findAll(Sort sort) throws DataAccessException;

	public Page<Materia> findAll(Pageable page) throws DataAccessException;

	public List<Materia> findAllMaterias();

	public Materia findOne(Integer id) throws DataAccessException;

	public long count();

	public void saveMateria(Materia materia) throws DataAccessException;

	public void saveEstudianteMateria(EstudianteMateria estumat) throws DataAccessException;


}
