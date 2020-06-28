package com.uca.capas.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.uca.capas.domain.CentroEscolar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class CentroEscolarDAOImpl implements CentroEscolarDAO {
	

	@Autowired
	JdbcTemplate jdbcTemplate;

	@PersistenceContext(unitName = "capas")
	EntityManager entityManager;
	
	@Override
	public List<CentroEscolar> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.centro_escolar");
		Query query = entityManager.createNativeQuery(sb.toString(), CentroEscolar.class);

		List<CentroEscolar> res = query.getResultList();
		return res;
	}

	@Override
	public int insertCentroEscolarAutoId(CentroEscolar c){
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
		.withSchemaName("public")
		.withTableName("centro_escolar")
		.usingGeneratedKeyColumns("c_CentroEscolar");

		Map<String,Object> parametros = new HashMap<String,Object>();
		parametros.put("nombre", c.getNombrecen());
		parametros.put("descripcion", c.getDescripcioncen());
		parametros.put("estado", c.getEstadocen());
		parametros.put("municipio", c.getMunicipiocen());


		Number id_generated = jdbcInsert.executeAndReturnKey(parametros);

		return id_generated.intValue();
	}
	private static final String sql = "UPDATE public.centro_escolar SET nombre = ?, descripcion = ?, estado = ?,municipio=? WHERE id = ?";
	
	@Override
	public void updateCentroEscolar(CentroEscolar c) {
		Object[] parametros = new Object[] {c.getNombrecen(), c.getDescripcioncen(), c.getEstadocen(), c.getMunicipiocen()};
		jdbcTemplate.update(sql, parametros);
	}

	@Override
	public int ejecutarProcedimientoJdbc(Integer CentroEscolar, Boolean estado) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("public")
				.withProcedureName("sp_actualizar_CentroEscolar")
				.withoutProcedureColumnMetaDataAccess();
		
		jdbcCall.addDeclaredParameter(new SqlParameter("P_CentroEscolar", Types.INTEGER));
		jdbcCall.addDeclaredParameter(new SqlParameter("P_ESTADO", Types.BOOLEAN));
		jdbcCall.addDeclaredParameter(new SqlOutParameter("P_SALIDA", Types.INTEGER));
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("P_CentroEscolar", CentroEscolar);
		parametros.put("P_ESTADO", estado);
		
		Map<String, Object> out = jdbcCall.execute(parametros);
		
		return Integer.parseInt(out.get("P_SALIDA").toString());
	}

	
	public CentroEscolar findOne(Integer codigo) throws DataAccessException {
		CentroEscolar c = entityManager.find(CentroEscolar.class, codigo);
		return c;
	}

	public void save(CentroEscolar c) throws DataAccessException {
		
		if(c.getIdcen() == null) { //Si la propiedad de la llave primaria viene vacío, entonces es un INSERT
			entityManager.persist(c); //Utilizamos persist ya que es un INSERT
		}
		else { //Caso contrario, se busco al CentroEscolar, por lo que la propiedad cCentroEscolar viene llena (el input hidden del formulario)
			entityManager.merge(c); //Utilizamos merge ya que es un UPDATE
		}
		
	}

	public List<CentroEscolar> getCentroEscolarEstado(Boolean estado) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<CentroEscolar> query = cb.createQuery(CentroEscolar.class);

		Root<CentroEscolar> CentroEscolars = query.from(CentroEscolar.class);

		Predicate predicate = cb.equal(CentroEscolars.get("estado_centro"), estado);

		query.select(CentroEscolars).where(predicate);

		List<CentroEscolar> resultado = entityManager.createQuery(query).getResultList();

		return resultado;
	}

	
	

	

	

	
}
