package com.uca.capas.service.Usuario;

import com.uca.capas.domain.Materia;
import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService
{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() throws DataAccessException
    {
        return usuarioRepository.findAll();
    }

    @Override
    public long count() { return usuarioRepository.count();}

    @Override
    @Transactional
    public void save(Usuario u) throws DataAccessException
    {
        try{
            usuarioRepository.save(u);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
