package com.uca.capas.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.dao.DataAccessException;
import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Municipio;

public interface CentroEscolarDAO {
	public List<CentroEscolar> findAll() throws DataAccessException;

	public CentroEscolar findOne(Integer codigo) throws DataAccessException;
	
	public void save(CentroEscolar c) throws DataAccessException;

	public List<CentroEscolar> getCentroEscolarEstado(Boolean estado);
    
	
	public int insertCentroEscolarAutoId(CentroEscolar c);

	public void updateCentroEscolar(CentroEscolar c);

	public int ejecutarProcedimientoJdbc(Integer CentroEscolar, Boolean estado);
	
}
