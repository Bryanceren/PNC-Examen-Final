package com.uca.capas.service.Usuario;

import com.uca.capas.domain.Materia;
import com.uca.capas.domain.Usuario;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UsuarioService
{
    public List<Usuario> findAll() throws DataAccessException;

    public long count();

    public void save(Usuario u) throws DataAccessException;
}
