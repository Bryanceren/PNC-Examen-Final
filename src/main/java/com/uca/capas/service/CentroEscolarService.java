package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Municipio;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface CentroEscolarService {
	
	public List<CentroEscolar> findAll() throws DataAccessException;

	public List<CentroEscolar> findAll(Sort sort);

	public Page<CentroEscolar> findAll(Pageable page) throws DataAccessException;

	public long count();

	public CentroEscolar findOne(Integer codigo) throws DataAccessException;

	public void save(CentroEscolar c) throws DataAccessException;

	public int insertCentroEscolarAutoId(CentroEscolar c);

	public void updateCentroEscolar(CentroEscolar c);

	public List<Municipio> findAllMunicipios();

	List<CentroEscolar> findfindCentroPorMuni(Integer fk);
	CentroEscolar findByIdcen(Integer code);





}
