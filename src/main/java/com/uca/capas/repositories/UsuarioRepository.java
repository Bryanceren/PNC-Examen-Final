package com.uca.capas.repositories;

import java.util.List;

import com.uca.capas.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>
{
    public Usuario findByUsername(String username);
    public Page<Usuario> findAll(Pageable page);


}
