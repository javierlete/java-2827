package com.ipartek.ipartex.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ipartek.ipartex.servicios.AutenticadoServiceImpl;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

	// AUTENTICACIÓN
	private final AutenticadoServiceImpl autenticadoService;
	private final DataSource dataSource;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth
	    	.jdbcAuthentication()
	    	.dataSource(dataSource)
	    	.passwordEncoder(passwordEncoder)
	    	.usersByUsernameQuery("""
SELECT email, password, 1
FROM usuarios
WHERE email=?
""")
	    	.authoritiesByUsernameQuery("""
SELECT email, 'ROLE_USUARIO'
FROM usuarios
WHERE email=? 
""");
	}
	
	// AUTORIZACIÓN
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(requests -> requests
				.anyRequest().permitAll()
			)
			.formLogin(form -> form
				.loginPage("/login")
				.successHandler((request, response, authentication) -> {
					var email = authentication.getName();
					var usuario = autenticadoService.buscarPorEmail(email);
					
					request.getSession().setAttribute("usuario", usuario);
					
					response.sendRedirect("/");
				})
				.permitAll()
			)
			.logout(LogoutConfigurer::permitAll);

		return http.build();
	}

}