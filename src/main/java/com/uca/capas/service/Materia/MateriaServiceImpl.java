package com.uca.capas.service.Materia;

import com.uca.capas.domain.Materia;
import com.uca.capas.repositories.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MateriaServiceImpl implements MateriaService
{
	@Autowired
	MateriaRepository materiaRepository;

	@Override
	public List<Materia> findAll(Sort sort) throws DataAccessException
	{
		return materiaRepository.findAll(sort);
	}

	@Override
	public Page<Materia> findAll(Pageable page) throws DataAccessException
	{
		return materiaRepository.findAll(page);
	}

	@Override
	public long count()
	{
		return materiaRepository.count();
	}
}
