package com.ipartek.formacion.springapp.servicios;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.springapp.adaptadores.UsuarioAdapter;
import com.ipartek.formacion.springapp.entidades.Usuario;
import com.ipartek.formacion.springapp.repositorios.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public String login(Usuario peticion) {
        UserDetails usuario = new UsuarioAdapter(peticion);

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));

        Usuario usuarioLogueado = usuarioRepository.findByEmail(usuario.getUsername()).orElseThrow();

        UserDetails userDetails = new UsuarioAdapter(usuarioLogueado);
        
        return jwtService.getToken(userDetails);
    }

    public String register(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol("USUARIO");

        usuarioRepository.save(usuario);

        UserDetails userDetails = new UsuarioAdapter(usuario);

        return jwtService.getToken(userDetails);
    }

}
