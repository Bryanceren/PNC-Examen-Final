package com.uca.capas.service.Authentication;

import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService implements UserDetailsService
{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Usuario usuario = usuarioRepository.findByUsername(username);

        if(usuario == null)
        {
            throw new BadCredentialsException(SpringSecurityMessageSource.getAccessor().getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Usuario o contraseña invalido"));
        }

        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(usuario.getRole()));

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEstado(), true, true, true, roles);
    }
}
