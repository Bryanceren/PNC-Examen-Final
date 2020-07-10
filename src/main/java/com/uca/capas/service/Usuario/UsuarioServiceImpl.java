package com.uca.capas.service.Usuario;

import com.uca.capas.dao.UsuarioDao;
import com.uca.capas.domain.Materia;
import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService
{
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioDao usuarioDao;

    @Override
    public List<Usuario> findAll() throws DataAccessException
    {
        return usuarioRepository.findAll();
    }
    @Override
    public Page<Usuario> findAll(Pageable page) throws DataAccessException {
		return usuarioRepository.findAll(page);
	}
    @Override
    public Usuario findOne(Integer codigo) throws DataAccessException {
		return usuarioRepository.getOne(codigo);
	}

    @Override
    public long count() { return usuarioRepository.count();}

    @Override
	public void updateUser(Usuario U) {
		usuarioDao.updateUser(U);
	}

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
