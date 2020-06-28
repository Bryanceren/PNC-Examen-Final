package com.uca.capas.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

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

	@Override
	public List<CentroEscolar> getCentroEscolarQueryMethod(Integer tipo, String valor1, String valor2) throws Exception {
		List<CentroEscolar> resultado = null;

		switch (tipo) {
			case 1:
				resultado = CentroEscolarRepository.findByNombrecen(valor1);
				break;

			case 2:
				break;

			case 3:
				break;

			case 4:
				break;

			case 5:
                break;
                
			case 6:
				break;

			case 7:
				break;

		
			case 8:
				List<String> nombres = new ArrayList<String>();
				nombres.add("Bryan");
				nombres.add("Del");
				nombres.add("Cordula");
				break;

			default:
				resultado = new ArrayList<>();
				break;

		}
		return resultado;
	}

	@Override
	public List<CentroEscolar> findAllCentroEscolar() {
		return CentroEscolarRepository.findAllCentroEscolar();
	}
    public List<Municipio> findAllMunicipios() {
        return CentroEscolarRepository.findAllMunicipios();
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
	@Override
	public int ejecutarProcJdbc(Integer CentroEscolar, Boolean estado) {
		return CentroEscolarDao.ejecutarProcedimientoJdbc(CentroEscolar, estado);
	}


	
	@Transactional
	public Integer actualizarCentroEscolar(Integer CentroEscolar, Boolean estado) {
		int res = 0;
		StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("store.sp_actualizar_CentroEscolar");

		storedProcedure.registerStoredProcedureParameter("P_CentroEscolar", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("P_ESTADO", Boolean.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("P_SALIDA", Integer.class, ParameterMode.OUT);

		storedProcedure.setParameter("P_CentroEscolar", CentroEscolar);
		storedProcedure.setParameter("P_ESTADO", estado);

		storedProcedure.execute();

		res = (int) storedProcedure.getOutputParameterValue("P_SALIDA");

		return res;
	}


   

  

	
}
