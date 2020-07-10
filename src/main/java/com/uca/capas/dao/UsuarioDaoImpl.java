package com.uca.capas.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.uca.capas.domain.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	

	@Autowired
	JdbcTemplate jdbcTemplate;

	@PersistenceContext(unitName = "capas")
	EntityManager entityManager;
	private static final String sql = "UPDATE public.usuario SET estado = ? WHERE id = ?";

	@Override
	public void updateUser(Usuario u) {
		Object[] parametros = new Object[] { u.getEstado(),u.getId()};
		jdbcTemplate.update(sql, parametros);
	}

	

	
}
