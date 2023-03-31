package com.project.SecurityJWT.security;

import com.project.SecurityJWT.entity.Usuario;
import com.project.SecurityJWT.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El email " + email + " es incorrecto."));

        return new UserDetailsImpl(usuario);
    }
}
