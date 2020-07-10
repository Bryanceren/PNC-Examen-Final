package com.uca.capas.service.Usuario;

import com.uca.capas.domain.Materia;
import com.uca.capas.domain.Usuario;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService
{
    public List<Usuario> findAll() throws DataAccessException;

    public Page<Usuario> findAll(Pageable page) throws DataAccessException;


    public long count();

    public void save(Usuario u) throws DataAccessException;

    public Usuario findOne(Integer codigo) throws DataAccessException;
    
	public void updateUser(Usuario u);

}
