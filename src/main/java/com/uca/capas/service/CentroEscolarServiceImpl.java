package com.uca.capas.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uca.capas.dao.CentroEscolarDAO;
import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Municipio;
import com.uca.capas.repositories.CentroEscolarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CentroEscolarServiceImpl implements CentroEscolarService {

	@Autowired
	CentroEscolarDAO CentroEscolarDao;

	@Autowired
	CentroEscolarRepository CentroEscolarRepository;

	@PersistenceContext(unitName = "capas")
	EntityManager entityManager;

	public List<CentroEscolar> findAll() throws DataAccessException {
		return CentroEscolarRepository.findAll();
    }
    
	public CentroEscolar findOne(Integer codigo) throws DataAccessException {
		return CentroEscolarRepository.getOne(codigo);
	}

	@Transactional
	public void save(CentroEscolar c) throws DataAccessException {
		CentroEscolarDao.save(c);
	}

    public List<Municipio> findAllMunicipios() {
        return CentroEscolarRepository.findAllMunicipios();
    }

	@Override
	public List<CentroEscolar> findfindCentroPorMuni(Integer fk) {
		return CentroEscolarRepository.findCentroPorMuni(fk);
	}

	@Override
	public CentroEscolar findByIdcen(Integer code) {
		return CentroEscolarRepository.findByIdcen(code);
	}

	public Page<CentroEscolar> findAll(Pageable page) throws DataAccessException {
		return CentroEscolarRepository.findAll(page);
	}

	public Long countAll() {
		return CentroEscolarRepository.count();
	}

	public List<CentroEscolar> findAll(Sort sort) {
		return CentroEscolarRepository.findAll(sort);
	}

	@Override
	public int insertCentroEscolarAutoId(CentroEscolar c) {
		return CentroEscolarDao.insertCentroEscolarAutoId(c);
	}

	@Override
	public void updateCentroEscolar(CentroEscolar c) {
		CentroEscolarDao.updateCentroEscolar(c);
	}

}
