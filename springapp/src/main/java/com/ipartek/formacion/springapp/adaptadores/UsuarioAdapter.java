package com.ipartek.formacion.springapp.adaptadores;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ipartek.formacion.springapp.entidades.Usuario;

public class UsuarioAdapter extends Usuario implements UserDetails {
    public UsuarioAdapter(Usuario usuario) {
        super(usuario.getId(), usuario.getEmail(), usuario.getPassword(), usuario.getRol());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(getRol()));
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

}
