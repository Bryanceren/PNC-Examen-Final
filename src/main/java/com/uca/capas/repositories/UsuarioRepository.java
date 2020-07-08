package com.uca.capas.repositories;

import com.uca.capas.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>
{
    public Usuario findByUsername(String username);
}
